package com.charlezz.modularizedsample;

import com.charlezz.core.CoreComponent;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(modules = {AndroidSupportInjectionModule.class, BaseActivityBindingModule.class}, dependencies = CoreComponent.class)
@Singleton
public interface AppComponent extends AndroidInjector<App> {
    void coreComponent(CoreComponentInjector injector);
}
