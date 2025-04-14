package StrdewValley.Models.Items.Tools;

import StrdewValley.Models.Enums.Quality;
import StrdewValley.Models.Items.Item;
import StrdewValley.Models.Items.ItemBehavior;

public class TrashCan extends Item {
    private Quality quality;

    public TrashCan(String name, int price, ItemBehavior behavior, Quality quality) {
        super(name, price, behavior);
        this.quality = quality;
    }

    @Override
    public Item copy() {
        return null;
    }
}
