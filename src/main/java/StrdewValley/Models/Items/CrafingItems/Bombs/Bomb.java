package StrdewValley.Models.Items.CrafingItems.Bombs;

import StrdewValley.Models.Items.CrafingItems.Behaviors.BombBehavior;
import StrdewValley.Models.Items.Item;
import StrdewValley.Models.Items.ItemBehavior;

public class Bomb extends Item {
    protected int blastRadius;

    public Bomb(String name, int price, int blastRadius) {
        super(name, price, new BombBehavior(blastRadius));
    }

    @Override
    public Item copy() {
        return null;
    }
}
