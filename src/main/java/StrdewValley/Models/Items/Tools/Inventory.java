package StrdewValley.Models.Items.Tools;

import StrdewValley.Models.Enums.Quality;
import StrdewValley.Models.Items.Item;
import StrdewValley.Models.Items.ItemBehavior;

import java.util.ArrayList;

public class Inventory extends Item {
    private Quality inventoryQuality;
    private ArrayList<Tool> myTools;

    public Inventory(String name, int price, ItemBehavior behavior) {
        super(name, price, behavior);
    }

    @Override
    public Item copy() {
        return null;
    }
}
