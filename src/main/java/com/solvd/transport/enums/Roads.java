package com.solvd.transport.enums;

public enum Roads {
    CRONCRETE ("concrete", 1),
    ASPHALT ("asphalt", 2),
    GRAVEL ("gravel", 3),
    WATER ("water",4),
    AIR ("air",5),
    ICE ("ice",6),
    AUTOPISTA ("autopista",7),
    ;
    private String road;
    private int num;

    Roads(String road, int num) {
        this.road = road;
        this.num = num;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}