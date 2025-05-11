package org.example.model.items;

public abstract class Item {
    protected final String name;
    protected final int basePrice;

    protected Item(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }
}