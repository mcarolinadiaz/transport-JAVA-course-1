package com.solvd.transport.enums;
/**
 * Enum representing different types of roads and their durability.
 */
public enum Roads {
    CRONCRETE ("concrete", 10),
    ASPHALT ("asphalt", 8),
    GRAVEL ("gravel", 5),
    EARTHEN ("earthen",2),
    MURRUM ("murrum",3)
    ;
    private String road;
    private int durability;
    /**
     * Constructor for Roads enum.
     * @param road The type of road.
     * @param durability The durability of the road.
     */
    Roads(String road, int durability) {
        this.road = road;
        this.durability = durability;
    }
    // Getters & Setters
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
    /**
     * Enum representing different road conditions.
     */
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

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }
    }
    /**
     * Get the road condition based on durability.
     */
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