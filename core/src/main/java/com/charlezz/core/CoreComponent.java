package com.charlezz.core;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {CoreModule.class})
public interface CoreComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        CoreComponent build();
    }
//    String provideHello();
//    SplitInstallManager provideSplitInstallManager();
//    void inject(Application app);
}
