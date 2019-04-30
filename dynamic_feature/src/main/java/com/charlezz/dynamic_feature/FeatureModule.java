package com.charlezz.dynamic_feature;

import android.databinding.DataBindingUtil;

import com.charlezz.core.ActivityScope;
import com.charlezz.dynamic_feature.databinding.ActivityFeatureBinding;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class FeatureModule{

    @Provides
    @ActivityScope
    static ActivityFeatureBinding provideBinding(FeatureActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_feature);
    }
}
