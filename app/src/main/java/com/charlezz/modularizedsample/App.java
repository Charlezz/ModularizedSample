package com.charlezz.modularizedsample;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.charlezz.core.ModuleInjector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class App extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;

    private List<DispatchingAndroidInjector<Activity>> moduleActivityInjectors = new ArrayList<>();
    private List<DispatchingAndroidInjector<Fragment>> moduleFragmentInjectors = new ArrayList<>();
    private HashSet<FeatureType> injectedModules = new HashSet<>();

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AndroidInjector<Activity> activityAndroidInjector = new AndroidInjector<Activity>() {
        @Override
        public void inject(Activity instance) {
            if (dispatchingActivityInjector.maybeInject(instance)) {
                return;
            }
            for (DispatchingAndroidInjector<Activity> each : moduleActivityInjectors) {
                if (each.maybeInject(instance)) {
                    return;
                }
            }

            throw new IllegalStateException("Injector not found for " + instance.getLocalClassName() + " instance");
        }
    };

    private AndroidInjector<Fragment> fragmentAndroidInjector = new AndroidInjector<Fragment>() {
        @Override
        public void inject(Fragment instance) {
            if (dispatchingFragmentInjector.maybeInject(instance)) {
                return;
            }
            for (DispatchingAndroidInjector<Fragment> each : moduleFragmentInjectors) {
                if (each.maybeInject(instance)) {
                    return;
                }
            }
            throw new IllegalStateException("Injector not found for " + instance.getTag() + " instance");
        }
    };

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentAndroidInjector;
    }

    public void addModuleInjector(FeatureType featureType) {
        if (injectedModules.contains(featureType)) {
            return;
        }
        try {
            Class clazz = Class.forName(featureType.getInjectorName());
            ModuleInjector moduleInjector = (ModuleInjector) clazz.newInstance();
            moduleInjector.inject(this);

            moduleActivityInjectors.add(moduleInjector.activityInjector());
            moduleFragmentInjectors.add(moduleInjector.fragmentInjector());

            injectedModules.add(featureType);
        } catch (Exception e) {
            Log.e("TestApp", e.toString());
        }
    }
}

