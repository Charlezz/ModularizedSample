package com.charlezz.starbucks;

import com.charlezz.starbucks.Ingredient.IngredientModule;

import dagger.Component;

@Component(modules = IngredientModule.class)
public interface Worker {
    Americano getAmericano();


}
