package com.charlezz.dynamic_feature;

import com.charlezz.core.AppScope;
import com.charlezz.modularizedsample.AppComponent;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, FeatureActivityBindingModule.class}, dependencies = {AppComponent.class})
@AppScope
public interface FeatureComponent {
    void inject(FeatureModuleInjector injector);
}
