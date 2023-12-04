package com.solvd.transport.enums;

public enum Country {
    JAPAN("Japan"),
    GERMANY("Germany"),
    MEXICO("Mexico"),
    UNITED_STATES("UnitedStates"),
    SWITZERLAND("Switzerland"),
    FRANCE("France"),
    ITALY("Italy"),
    ;
    private String country;
    Country(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                '}';
    }
}
