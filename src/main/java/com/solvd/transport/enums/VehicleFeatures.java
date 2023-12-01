package com.solvd.transport.enums;

public enum VehicleFeatures { 
    GPS("gps"),
    BLUETOOTH("bluetooth"),
    FOUR_WHEEL_DRIVE("fourWheelDrive"),
    HYBRID("hybrid"),
    SUNROOF("sunroof");

    private final String feature;

    // Constructor
    VehicleFeatures(String feature) {
        this.feature = feature;
    }
    public String getFeature() {
        return feature;
    }
}
