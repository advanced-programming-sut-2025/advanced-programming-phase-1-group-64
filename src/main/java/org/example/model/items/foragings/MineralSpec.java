package org.example.model.items.foragings;

public final class MineralSpec {
    private final String name;
    private final String description;
    private final int sellPrice;

    public MineralSpec(String name, String description, int sellPrice) {
        this.name = name;
        this.description = description;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    @Override
    public String toString() {
        return "*";
    }
}