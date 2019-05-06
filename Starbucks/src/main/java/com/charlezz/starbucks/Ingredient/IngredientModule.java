package com.charlezz.starbucks.Ingredient;

import dagger.Module;
import dagger.Provides;

@Module(includes = WaterModule.class)
public class IngredientModule {

    @Provides
    static Milk provideMilk(){
        return new Milk();
    }
}
