package org.example.model.items.tools.quality;

public enum FishingQuality {
    TRAINING,
    BAMBOO,
    FIBERGLASS,
    IRIDIUM;

    public FishingQuality upgrade(){
        return switch (this){
            case TRAINING -> BAMBOO;
            case BAMBOO -> FIBERGLASS;
            case FIBERGLASS -> IRIDIUM;
            case IRIDIUM -> null;
        };
    }
}
