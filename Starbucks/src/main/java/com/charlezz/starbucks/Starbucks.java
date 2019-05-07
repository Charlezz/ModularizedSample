package com.charlezz.starbucks;

import javax.inject.Inject;

public class Starbucks {
    @Inject
    Worker worker;

    public Starbucks(){
        inject();
    }

    void inject(){
        DaggerStarbucksComponent.builder()
                .worker(DaggerWorker.create())
                .build()
                .inject(this);
    }
}
