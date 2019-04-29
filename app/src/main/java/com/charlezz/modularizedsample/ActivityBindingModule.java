package com.charlezz.modularizedsample;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
