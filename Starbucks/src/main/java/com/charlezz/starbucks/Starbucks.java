package com.charlezz.starbucks;

import com.charlezz.starbucks.Ingredient.IngredientModule;

import dagger.Component;

@Component(modules = {IngredientModule.class})
public interface Starbucks {
    Americano makeAmericano();
    Latte makeLatte();

    @Component.Builder
    interface Builder{
        Starbucks build();
    }
    void inject(Test test);
}
