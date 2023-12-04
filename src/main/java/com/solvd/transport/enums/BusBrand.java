package com.solvd.transport.enums;

public enum BusBrand {
    MERCEDES("Mercedes", Country.GERMANY),
    VOLVO("Volvo", Country.SWITZERLAND),
    SCANIA("Scania", Country.SWITZERLAND);

    private final String brandName;
    private Country country;

    // Constructor
    BusBrand(String brandName, Country country) {
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
        return "BusBrand{" +
                "brandName='" + brandName + '\'' +
                ", country=" + country +
                '}';
    }
}
