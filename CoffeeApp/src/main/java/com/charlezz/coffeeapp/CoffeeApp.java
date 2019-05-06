package com.charlezz.coffeeapp;

import javax.inject.Singleton;

import dagger.Component;

public class CoffeeApp {

    public static void main(String[] args) {
        CoffeeShop coffeeShop = DaggerCoffeeShop.builder().build();
        CoffeeMaker maker = coffeeShop.getCoffeeMaker();
        maker.brew();
    }
}