package com.charlezz.starbucks;

import javax.inject.Inject;

public class Starbucks {

    @Inject
    Americano americano;
    @Inject
    Latte latte;

    public Starbucks(){
        DaggerStarbucksComponent.create().inject(this);
    }

}
