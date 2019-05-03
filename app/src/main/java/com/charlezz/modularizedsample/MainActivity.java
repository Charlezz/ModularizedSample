package com.charlezz.modularizedsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.charlezz.modularizedsample.databinding.ActivityMainBinding;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    ActivityMainBinding binding;
    @Inject
    String message;

    @Inject
    SplitInstallManager splitInstallManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        splitInstallManager.getInstalledModules();

        Log.e(TAG,"message = "+message);
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SplitInstallRequest request = SplitInstallRequest.newBuilder().addModule("dynamic_feature")
                        .build();
                splitInstallManager
                        .startInstall(request)
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(Exception e) {
                                Log.e(TAG,"onFailure");
                            }
                        })
                        .addOnSuccessListener(new OnSuccessListener<Integer>() {
                            @Override
                            public void onSuccess(Integer integer) {
                                Log.e(TAG,"onSuccess");

                                Intent intent = new Intent();
                                intent.setClassName(getPackageName(), FeatureType.FEATURE.getActivityName());
                                startActivity(intent);

                            }
                        });
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
