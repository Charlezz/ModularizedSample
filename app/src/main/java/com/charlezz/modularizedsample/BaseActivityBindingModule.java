package com.charlezz.modularizedsample;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BaseActivityBindingModule {
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
