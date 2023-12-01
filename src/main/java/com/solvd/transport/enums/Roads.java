package com.solvd.transport.enums;

public enum Roads {
    CRONCRETE ("concrete", 10),
    ASPHALT ("asphalt", 8),
    GRAVEL ("gravel", 5),
    EARTHEN ("earthen",2),
    MURRUM ("murrum",3)
    ;
    private String road;
    private int durability;

    Roads(String road, int durability) {
        this.road = road;
        this.durability = durability;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int num) {
        this.durability = durability;
    }

    public enum RoadCondition {
        EXCELLENT("Excellent"),
        GOOD("Good"),
        AVERAGE("Average"),
        POOR("Poor"),
        BAD("Bad")
        ;

        private String condition;

        RoadCondition(String condition) {
            this.condition = condition;
        }

    }

    public RoadCondition getRoadCondition() {
        if (this.durability > 8) {
            return RoadCondition.EXCELLENT;
        } else if (this.durability <= 8 && this.durability > 6) {
            return RoadCondition.GOOD;
        } else if (this.durability <= 6 && this.durability > 4) {
            return RoadCondition.AVERAGE;
        } else if (this.durability <= 4 && this.durability > 2) {
            return RoadCondition.POOR;
        } else {
            return RoadCondition.BAD;
        }
    }

}