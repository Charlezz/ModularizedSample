package com.charlezz.starbucks;

import com.charlezz.starbucks.Ingredient.IngredientModule;

import dagger.Component;

@Component(
        modules = {IngredientModule.class},
        dependencies = Worker.class
        )
public interface StarbucksComponent {
    void inject(Starbucks app);
}
