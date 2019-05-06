package com.charlezz.starbucks.Ingredient;

import javax.inject.Inject;

public class Espresso {
    @Inject
    public Espresso(Water water){
        System.out.println("make Espresso");
    }
}
