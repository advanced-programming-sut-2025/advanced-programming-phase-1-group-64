package org.example.model.characters.inventory;

import org.example.model.items.tools.quality.ToolQuality;

public enum TrashQuality {
    BASIC(0),
    COPPER(0.15),
    IRON(0.3),
    GOLDEN(0.45),
    IRIDIUM(0.6);

    private final double returningSalesValue;

    TrashQuality(double returningSalesValue) {
        this.returningSalesValue = returningSalesValue;
    }

    public TrashQuality upgrade(){
        return switch (this){
            case BASIC -> COPPER;
            case COPPER -> IRON;
            case IRON -> GOLDEN;
            case GOLDEN -> IRIDIUM;
            case IRIDIUM -> null;
        };
    }

    public double getReturningSalesValue() {
        return returningSalesValue;
    }
}