package com.charlezz.modularizedsample;

import android.app.Application;

import com.charlezz.core.CoreComponent;
import com.charlezz.core.DaggerCoreComponent;

public class App extends Application{
    private static CoreComponent coreComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        coreComponent = DaggerCoreComponent.create();
    }
    public static CoreComponent getCoreComponent(){
        return coreComponent;
    }

}

