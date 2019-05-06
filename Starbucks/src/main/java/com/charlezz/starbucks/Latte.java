package com.charlezz.starbucks;

import javax.inject.Inject;

import com.charlezz.starbucks.Ingredient.Espresso;
import com.charlezz.starbucks.Ingredient.Milk;

public class Latte {
    private Espresso espresso;
    private Milk milk;

    @Inject
    public Latte(Espresso espresso, Milk milk){
        this.espresso = espresso;
        this.milk = milk;
    }
}
