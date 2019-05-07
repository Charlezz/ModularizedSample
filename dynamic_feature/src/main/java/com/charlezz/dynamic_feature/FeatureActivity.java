package com.charlezz.dynamic_feature;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.charlezz.dynamic_feature.databinding.ActivityFeatureBinding;
import com.charlezz.modularizedsample.App;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerApplication;

public class FeatureActivity extends AppCompatActivity {

    @Inject
    String message;

    @Inject
    ActivityFeatureBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        binding.setMessage(message);
        DaggerApplication

    }

    void inject(){
        DaggerFeatureComponent.builder()
                .coreComponent(App.getCoreComponent())
                .featureActivity(this)
                .build()
                .inject(this);
    }
}
