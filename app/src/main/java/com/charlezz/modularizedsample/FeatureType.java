package com.charlezz.modularizedsample;

public enum FeatureType {
    PHOTO_SELECTOR("com.nhn.android.band.photoselector.di.SelectorModuleInjector"),
    EDITOR("com.nhn.android.band.editor.dagger.FeatureModuleInjector");


    private String className;

    FeatureType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
