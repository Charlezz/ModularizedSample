package com.charlezz.modularizedsample;

import android.databinding.DataBindingUtil;

import com.charlezz.core.ActivityScope;
import com.charlezz.modularizedsample.databinding.ActivityMainBinding;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {
    @Provides
    @ActivityScope
    static ActivityMainBinding provideBinding(MainActivity activity){
        return DataBindingUtil.setContentView(activity,R.layout.activity_main);
    }
}
