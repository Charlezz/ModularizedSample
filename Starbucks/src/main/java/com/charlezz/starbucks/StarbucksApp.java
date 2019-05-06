package com.charlezz.starbucks;

import com.charlezz.starbucks.Ingredient.Milk;

public class StarbucksApp {

    public static void main(String[] args){
        Test test = new Test();
        Starbucks starbucks = DaggerStarbucks.builder()
                .build();
        starbucks.inject(test);

        if(test.milk==null){
            System.out.println("milk is null");
        }else{
            System.out.println("milk is injected");
        }

//        Americano americano = starbucks.makeAmericano();
//        Latte latte = starbucks.makeLatte();
    }
}
