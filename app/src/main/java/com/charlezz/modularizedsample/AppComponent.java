package com.charlezz.modularizedsample;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBindingModule.class
        }
)
public interface AppComponent extends AndroidInjector<App> {
}
