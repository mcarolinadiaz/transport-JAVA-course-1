package com.solvd.transport.enums;

public enum Propulsion {
    GASOLINE("gasoline", 1),
    DIESEL("diesel", 2),
    NATURAL_GAS("naturalGas", 3),
    PROPANE("propane",4),
    ETHANOL("ethanol",5),
    METHANOL("methanol",6),
    HYDROGEN("hydrogen",7),
    BIODIESEL("biodiesel",8),
    ;
    private String propulsion;
    private int num;

    Propulsion(String propulsion, int num) {
        this.propulsion = propulsion;
        this.num = num;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(String propulsion) {
        this.propulsion = propulsion;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}






















