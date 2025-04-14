package StrdewValley.Models.Items.CookingItems;

import StrdewValley.Models.Items.Item;

import java.util.Map;

public class CookingItem extends Item {
    private Map<Item, Integer> ingridient;
    private int energy;
    //TODO

    public CookingItem(String name, int price) {
        super(name, price);
    }

    @Override
    public Item copy() {
        return null;
    }
}
