package StrdewValley.Models.Items.CrafingItems.Behaviors;

import StrdewValley.Models.Items.ItemBehavior;

public class BombBehavior implements ItemBehavior {
    private int blastRadius;
    public BombBehavior(int blastRadius){
        this.blastRadius = blastRadius;
    }
    @Override
    public void execute() {

    }
}
