package com.charlezz.core;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class CoreModule {
    public static final String TAG = CoreModule.class.getSimpleName();

    @Provides
    static String provideMessage(){
        Log.e(TAG,"provideMessage");
        return "Hello World!!";
    }
}
