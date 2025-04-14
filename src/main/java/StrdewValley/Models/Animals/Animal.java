package StrdewValley.Models.Animals;

import StrdewValley.Models.Items.Item;

import java.util.Map;

public class Animal {
    private String name;
    private int priceCost;
    private Map<Item, Integer> mahsol;
    private boolean isInCoop;

    public Animal(String name, int priceCost, boolean isInCoop) {
        this.name = name;
        this.priceCost = priceCost;
        this.isInCoop = isInCoop;
    }
}
