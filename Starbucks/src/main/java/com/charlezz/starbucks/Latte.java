package com.charlezz.starbucks;

import com.charlezz.starbucks.Ingredient.Espresso;
import com.charlezz.starbucks.Ingredient.Milk;

import javax.inject.Inject;

public class Latte implements Coffee {
    private Espresso espresso;
    private Milk milk;

    @Inject
    public Latte(Espresso espresso, Milk milk){
        this.espresso = espresso;
        this.milk = milk;
    }

    @Override
    public String name() {
        return "라떼";
    }
}
