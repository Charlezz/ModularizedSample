package com.charlezz.modularizedsample;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(modules = {AndroidSupportInjectionModule.class, BaseActivityBindingModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<SampleApplication> {
}
