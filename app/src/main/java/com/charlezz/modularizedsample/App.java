package com.charlezz.modularizedsample;

import android.content.Context;

import com.charlezz.core.CoreComponent;
import com.charlezz.core.DaggerCoreComponent;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.SplitCompatApplication;

import dagger.android.DaggerActivity;

public class App extends SplitCompatApplication {
    private static CoreComponent coreComponent;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SplitCompat.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerActivity
        coreComponent = DaggerCoreComponent.builder()
                .application(this)
                .build();
//        coreComponent.inject(this);
    }
    public static CoreComponent getCoreComponent(){
        return coreComponent;
    }

}

