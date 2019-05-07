package com.charlezz.starbucks;

public class Charles implements Human {

    private Coffee drink;
    public Charles(Coffee drink){
        this.drink = drink;
    }

    @Override
    public String name() {
        return "찰스";
    }

    @Override
    public void drink(Coffee drink) {
        String message = String.format("%s는 %s를 마십니다.", name(), drink.name());
        System.out.println(message);
    }
}
