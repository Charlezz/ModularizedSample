package com.charlezz.coffeeapp;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DripCoffeeModule.class})
public interface CoffeeShop {
    CoffeeMaker getCoffeeMaker();
}
