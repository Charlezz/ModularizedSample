package com.charlezz.starbucks;

import com.charlezz.starbucks.Ingredient.IngredientModule;

import dagger.Component;

@Component(modules = {IngredientModule.class})
public interface StarbucksComponent {
//    Americano makeAmericano();
//    Latte makeLatte();
//    @Component.Builder
//    interface Builder{
//        StarbucksComponent build();
//    }
    void inject(Starbucks app);
}
