package StrdewValley.Models.Items.CrafingItems.Sprinklers;

import StrdewValley.Models.Items.Item;
import StrdewValley.Models.Items.ItemBehavior;

public class Sprinkler extends Item {
    protected int tilesRadius;

    public Sprinkler(String name, int price, ItemBehavior behavior) {
        super(name, price, behavior);
    }

    @Override
    public Item copy() {
        return null;
    }
}
