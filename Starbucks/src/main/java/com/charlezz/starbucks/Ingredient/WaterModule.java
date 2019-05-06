package com.charlezz.starbucks.Ingredient;

import dagger.Module;
import dagger.Provides;

@Module
public class WaterModule {
    @Provides
    static Water provideWater(){
        return new Water();
    }
}
