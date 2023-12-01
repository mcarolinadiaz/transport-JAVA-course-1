package com.solvd.transport.enums;

public enum Propulsion {
    GASOLINE("gasoline", FuelType.LIQUID),
    DIESEL("diesel", FuelType.LIQUID),
    NATURAL_GAS("naturalGas", FuelType.GAS),
    PROPANE("propane", FuelType.GAS),
    ETHANOL("ethanol", FuelType.LIQUID),
    METHANOL("methanol", FuelType.LIQUID),
    HYDROGEN("hydrogen", FuelType.GAS),
    BIODIESEL("biodiesel", FuelType.LIQUID),
    ;
    private String propulsion;
    private FuelType fuelType;

    Propulsion(String propulsion, FuelType fuelType) {
        this.propulsion = propulsion;
        this.fuelType = fuelType;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(String propulsion) {
        this.propulsion = propulsion;
    }

    public enum FuelType {
        LIQUID("Liquid"),
        GAS("Gas"),
        ;
        private String type;
        FuelType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}






















