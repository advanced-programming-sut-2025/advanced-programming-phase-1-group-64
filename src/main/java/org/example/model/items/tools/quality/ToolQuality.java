package org.example.model.items.tools.quality;

public enum ToolQuality {
    BASIC,
    COPPER,
    IRON,
    GOLDEN,
    IRIDIUM;

    public ToolQuality upgrade(){
        return switch (this){
            case BASIC -> COPPER;
            case COPPER -> IRON;
            case IRON -> GOLDEN;
            case GOLDEN -> IRIDIUM;
            case IRIDIUM -> null;
        };
    }
}