package org.example.model.items.foragings;

import org.example.model.items.Item;

public final class Mineral extends Item {
    private final String description;

    public Mineral(String name, int price, String description) {
        super(name, price);
        this.description = description;
    }
}