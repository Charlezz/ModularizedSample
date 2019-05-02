package com.charlezz.core;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {CoreModule.class})
@Singleton
public interface CoreComponent {
    @Component.Builder
    interface Builder{
        CoreComponent build();
    }
}
