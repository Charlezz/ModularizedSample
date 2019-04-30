package com.charlezz.modularizedsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.charlezz.modularizedsample.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplication()).addModuleInjector(FeatureType.FEATURE);

                Intent intent = new Intent();
                intent.setClassName(getPackageName(), FeatureType.FEATURE.getActivityName());
                startActivity(intent);
            }
        });
    }
}
