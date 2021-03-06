package com.charlezz.dynamic_feature;


import com.charlezz.core.BaseActivityComponent;
import com.charlezz.core.CoreComponent;
import com.charlezz.core.di.scope.FeatureScope;

import dagger.BindsInstance;
import dagger.Component;

@Component(
        modules = {FeatureModule.class},
        dependencies = {CoreComponent.class})
@FeatureScope
public interface FeatureComponent extends BaseActivityComponent<FeatureActivity> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder featureActivity(FeatureActivity activity);
        Builder coreComponent(CoreComponent coreComponent);
        FeatureComponent build();

    }

}
