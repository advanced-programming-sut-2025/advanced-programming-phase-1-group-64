package StrdewValley.Models.Items.Seeds;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Items.Item;

public class ForagingSeed extends Seed {
    private SeasonType[] season;

    public ForagingSeed(String name, SeasonType[] seasonTypes) {
        super(name,0,seasonTypes);
    }

    @Override
    public Item copy() {
        return null;
    }
}