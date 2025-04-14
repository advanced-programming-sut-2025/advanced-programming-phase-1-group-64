package StrdewValley.Models.Items.CrafingItems.Behaviors;

import StrdewValley.Models.Items.ItemBehavior;

public class SprinklerBehavior implements ItemBehavior {
    private int tilesRadius;

    public SprinklerBehavior(int tilesRadius) {
        this.tilesRadius = tilesRadius;
    }

    @Override
    public void execute() {

    }
}