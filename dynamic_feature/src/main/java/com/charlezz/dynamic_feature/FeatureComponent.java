package com.charlezz.dynamic_feature;

import com.charlezz.core.CoreModule;
import com.charlezz.core.ModuleScope;
import com.charlezz.modularizedsample.AppComponent;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, FeatureActivityBindingModule.class, CoreModule.class}, dependencies = {AppComponent.class})
@ModuleScope
public interface FeatureComponent {
    void inject(FeatureModuleInjector injector);
}
