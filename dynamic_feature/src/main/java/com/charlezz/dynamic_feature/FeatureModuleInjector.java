package com.charlezz.dynamic_feature;
import android.app.Activity;
import android.support.v4.app.Fragment;

import com.charlezz.core.CoreModule;
import com.charlezz.core.ModuleInjector;
import com.charlezz.modularizedsample.App;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

public class FeatureModuleInjector extends ModuleInjector<App> {
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    public void inject(App application) {
        DaggerFeatureComponent.builder()
                .appComponent(application.getAppComponent())
                .build()
                .inject(this);

    }

    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
