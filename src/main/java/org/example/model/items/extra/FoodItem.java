package org.example.model.items.extra;

import org.example.model.items.Item;

public class FoodItem extends Item {
    public final int energy;

    public FoodItem(String name, int basePrice, int energy) {
        super(name, basePrice);
        this.energy = energy;
    }

    public static FoodItem createFoodItem(String name, int basePrice, int energy) {
        return new FoodItem(name, basePrice, energy);
    }
}