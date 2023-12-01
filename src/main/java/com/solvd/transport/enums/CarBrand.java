package com.solvd.transport.enums;

public enum CarBrand {
    TOYOTA("Toyota"),
    HONDA("Honda"),
    FORD("Ford");

    private final String brandName;

    // Constructor
    CarBrand(String brandName) {
        this.brandName = brandName;
    }
    public String getBrandName() {
        return brandName;
    }
}
