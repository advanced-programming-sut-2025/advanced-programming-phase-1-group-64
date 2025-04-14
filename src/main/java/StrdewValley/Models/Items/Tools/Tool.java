package StrdewValley.Models.Items.Tools;

import StrdewValley.Models.Enums.CellKind;
import StrdewValley.Models.Enums.Quality;
import StrdewValley.Models.Items.Item;
import StrdewValley.Models.Items.ItemBehavior;

public class Tool extends Item {
    private Quality toolQuality;
    private CellKind[] cellKinds;

    public Tool(String name, int price, Quality toolQuality, CellKind[] cellKinds) {
        super(name, price);
        this.toolQuality = toolQuality;
        this.cellKinds = cellKinds;
    }

    public Tool(String name, int price, ItemBehavior behavior, Quality toolQuality, CellKind[] cellKinds) {
        super(name, price, behavior);
        this.toolQuality = toolQuality;
        this.cellKinds = cellKinds;
    }

    @Override
    public Item copy() {
        return null;
    }
}