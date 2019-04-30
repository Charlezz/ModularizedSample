package com.charlezz.modularizedsample;

public enum FeatureType {
    FEATURE("com.charlezz.dynamic_feature.FeatureActivity", "com.charlezz.dynamic_feature.FeatureModuleInjector");
    //addtional feature here

    private String activityName;
    private String injectorName;

    FeatureType(String activityName, String injectorName) {
        this.activityName = activityName;
        this.injectorName = injectorName;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getInjectorName() {
        return injectorName;
    }
}
