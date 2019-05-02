package com.charlezz.dynamic_feature;

import android.databinding.DataBindingUtil;

import com.charlezz.core.di.scope.FeatureScope;
import com.charlezz.dynamic_feature.databinding.ActivityFeatureBinding;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class FeatureModule{

    @Provides
    @FeatureScope
    static ActivityFeatureBinding provideBinding(FeatureActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_feature);
    }
}
