package com.charlezz.core;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import dagger.android.DispatchingAndroidInjector;

public abstract class ModuleInjector<T extends Application> {
    public abstract DispatchingAndroidInjector<Activity> activityInjector();
    public abstract DispatchingAndroidInjector<Fragment> fragmentInjector();
    public abstract void inject(T application);
}
