package com.charlezz.core;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import dagger.android.DispatchingAndroidInjector;

public interface BaseModuleInjector<T extends Application> {
    DispatchingAndroidInjector<Activity> activityInjector();
    DispatchingAndroidInjector<Fragment> fragmentInjector();
    void inject(T application);
}
