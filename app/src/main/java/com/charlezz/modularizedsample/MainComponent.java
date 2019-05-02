package com.charlezz.modularizedsample;

import com.charlezz.core.BaseActivityComponent;
import com.charlezz.core.CoreComponent;
import com.charlezz.core.di.scope.FeatureScope;

import dagger.BindsInstance;
import dagger.Component;


@Component(
        modules = {MainModule.class},
        dependencies = CoreComponent.class
)
@FeatureScope
public interface MainComponent extends BaseActivityComponent<MainActivity> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder mainActivity(MainActivity activity);

        Builder coreComponent(CoreComponent coreComponent);

        MainComponent build();
    }
}
