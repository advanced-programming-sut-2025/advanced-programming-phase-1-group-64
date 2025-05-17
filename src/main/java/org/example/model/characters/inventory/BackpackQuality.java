package org.example.model.characters.inventory;

public enum BackpackQuality {
    BASIC(12),
    BIG(24),
    DELUXE(1_000_000);

    private final int size;

    BackpackQuality(int size) {
        this.size = size;
    }

    public BackpackQuality upgrade(){
        return switch (this){
            case BASIC -> BIG;
            case BIG -> DELUXE;
            case DELUXE -> null;
        };
    }

    public int getSize() {
        return size;
    }
}