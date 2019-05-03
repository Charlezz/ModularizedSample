package com.charlezz.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;

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

    @Provides
    @Singleton
    static Context provideContext(Application app){
        return app;
    }

    @Provides
    @Singleton
    static SplitInstallManager provideSplitInstallManager(Context context){
        return SplitInstallManagerFactory.create(context);
    }
}
