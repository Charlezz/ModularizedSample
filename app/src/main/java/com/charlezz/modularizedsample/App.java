package com.charlezz.modularizedsample;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.charlezz.core.BaseModuleInjector;
import com.google.android.play.core.splitcompat.SplitCompatApplication;

import java.util.ArrayList;
import java.util.HashSet;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class App extends SplitCompatApplication implements HasActivityInjector, HasSupportFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingFagmentInjector;

    private ArrayList<DispatchingAndroidInjector<Activity>> moduleActivityInjectors = new ArrayList<>();
    private ArrayList<DispatchingAndroidInjector<Fragment>> moduleFragmentInjectors = new ArrayList<>();

    private AndroidInjector<Activity> activityInjector = new AndroidInjector<Activity>() {
        @Override
        public void inject(Activity instance) {
            if (dispatchingActivityInjector.maybeInject(instance)) {
                return;
            }

            for(DispatchingAndroidInjector<Activity> injector : moduleActivityInjectors){
                if (injector.maybeInject(instance)) {
                    return;
                }
            }
            throw new IllegalStateException("Injector not found for $instance");
        }
    };

    private AndroidInjector<Fragment> fragmentInjector = new AndroidInjector<Fragment>() {
        @Override
        public void inject(Fragment instance) {
            if (dispatchingFagmentInjector.maybeInject(instance)) {
                return;
            }


            for(DispatchingAndroidInjector<Fragment> injector : moduleFragmentInjectors){
                if (injector.maybeInject(instance)) {
                    return;
                }
            }
            throw new IllegalStateException("Injector not found for $instance");
        }
    };

    private HashSet<ModuleInfo> injectedModules = new HashSet<>();
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    @SuppressWarnings("unchecked")
    public void addModuleInjector(ModuleInfo module){
        if(injectedModules.contains(module)){
            return;
        }

        try {
            Class clazz = Class.forName(module.getInjectorName());
            BaseModuleInjector baseModuleInjector = (BaseModuleInjector) clazz.newInstance();
            baseModuleInjector.inject(this);

            moduleActivityInjectors.add(baseModuleInjector.activityInjector());
            moduleFragmentInjectors.add(baseModuleInjector.fragmentInjector());

            injectedModules.add(module);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

