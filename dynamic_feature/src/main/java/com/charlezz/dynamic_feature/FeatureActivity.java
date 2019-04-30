package com.charlezz.dynamic_feature;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.charlezz.dynamic_feature.databinding.ActivityFeatureBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class FeatureActivity extends DaggerAppCompatActivity {

    @Inject
    String message;

    @Inject
    ActivityFeatureBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setMessage(message);

    }
}
