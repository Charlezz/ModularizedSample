package com.charlezz.starbucks.Ingredient;

import com.charlezz.starbucks.Americano;

import dagger.Module;
import dagger.Provides;

@Module(includes = WaterModule.class)
public class IngredientModule {

    @Provides
    static Milk provideMilk(){
        return new Milk();
    }

    @Provides
    static Espresso provideEspresso(Water water){
        return new Espresso(water);
    }
    @Provides
    static Americano provideAmericano(Espresso espresso, Water water){
        return new Americano(espresso, water);
    }
}
