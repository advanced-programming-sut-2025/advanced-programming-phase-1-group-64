package StrdewValley.Models.Items.Seeds;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Items.Item;

public abstract class Seed extends Item {
    private SeasonType[] seasonTypes;
    public Seed(String name, SeasonType[] seasonTypes) {
        super(name);
        this.seasonTypes = seasonTypes;
    }
}