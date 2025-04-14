package StrdewValley.Models.Items.Seeds;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Items.Item;

public abstract class Seed extends Item {
    private SeasonType[] seasonTypes;
    public Seed(String name, int price, SeasonType[] seasonTypes) {
        super(name, price);
        this.seasonTypes = seasonTypes;
    }
}