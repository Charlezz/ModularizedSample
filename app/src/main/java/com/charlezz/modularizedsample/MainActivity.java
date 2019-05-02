package com.charlezz.modularizedsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.charlezz.modularizedsample.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(getPackageName(), FeatureType.FEATURE.getActivityName());
                startActivity(intent);
            }
        });


    }

    void inject(){
        DaggerMainComponent.builder()
                .coreComponent(App.getCoreComponent())
                .mainActivity(this)
                .build()
                .inject(this);
    }

}
