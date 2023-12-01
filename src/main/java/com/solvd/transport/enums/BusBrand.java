package com.solvd.transport.enums;

public enum BusBrand {
    MERCEDES("Mercedes"),
    VOLVO("Volvo"),
    SCANIA("Scania");

    private final String brandName;

    // Constructor
    BusBrand(String brandName) {
        this.brandName = brandName;
    }
    public String getBrandName() {
        return brandName;
    }
}
