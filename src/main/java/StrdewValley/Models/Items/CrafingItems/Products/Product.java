package StrdewValley.Models.Items.CrafingItems.Products;

import StrdewValley.Models.Items.Item;
import StrdewValley.Models.Time;

public class Product extends Item {
    private int energy;
    private Time processingTime;

    public Product(String name, int energy, Time processingTime, int price) {
        super(name, price);
        this.energy = energy;
        this.processingTime = processingTime;
    }

    @Override
    public Item copy() {
        return null;
    }
}