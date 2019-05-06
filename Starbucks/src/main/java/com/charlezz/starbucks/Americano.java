package com.charlezz.starbucks;

import javax.inject.Inject;

import com.charlezz.starbucks.Ingredient.Espresso;
import com.charlezz.starbucks.Ingredient.Water;

public class Americano {
    private Espresso espresso;
    private Water water;

    @Inject
    public Americano(Espresso espresso, Water water){
        this.espresso = espresso;
        this.water = water;
        System.out.println("make Americano");
    }
}
