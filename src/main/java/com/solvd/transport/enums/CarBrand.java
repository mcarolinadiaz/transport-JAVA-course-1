package com.solvd.transport.enums;

public enum CarBrand {
    TOYOTA("Toyota", Country.JAPAN),
    HONDA("Honda", Country.JAPAN),
    FORD("Ford", Country.UNITED_STATES);

    private final String brandName;
    private Country country;

    // Constructor
    CarBrand(String brandName, Country country) {
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
}
