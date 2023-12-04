package com.solvd.transport.enums;

public enum LorryBrand {
    MERCEDES("Mercedes", Country.GERMANY),
    IVECO("Iveco", Country.ITALY),
    RENAULT("Renault", Country.FRANCE),
    SCANIA("Scania", Country.SWITZERLAND);

    private final String brandName;
    private Country country;

    // Constructor
    LorryBrand(String brandName, Country country) {
        this.brandName = brandName;
        this.country = country;
    }
    public String getBrandName() {
        return brandName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country.setCountry(country.getCountry());
    }

    @Override
    public String toString() {
        return "LorryBrand{" +
                "brandName='" + brandName + '\'' +
                ", country=" + country +
                '}';
    }
}
