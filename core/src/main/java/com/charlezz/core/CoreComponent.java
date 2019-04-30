package com.charlezz.core;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, CoreModule.class})
public interface CoreComponent {
}
