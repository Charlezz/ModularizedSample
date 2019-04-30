package com.charlezz.core;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class CoreModule {
    public static final String TAG = CoreModule.class.getSimpleName();

    @Provides
    @Singleton
    static String provideMessage(){
        Log.e(TAG,"provideMessage");
        return "Hello World!!";
    }
}
