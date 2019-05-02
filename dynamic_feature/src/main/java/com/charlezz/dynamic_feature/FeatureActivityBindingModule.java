package com.charlezz.dynamic_feature;
import com.charlezz.core.di.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FeatureActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {FeatureModule.class})
    abstract FeatureActivity featureActivity();
}
