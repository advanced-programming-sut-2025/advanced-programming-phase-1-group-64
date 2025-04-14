package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;

public class ForagingCrop extends Item{
    private SeasonType[] season;
    private int energy;

    public ForagingCrop(String name, SeasonType[] season, int baseSellPrice, int energy) {
        super(name, baseSellPrice);
        this.season = season;
        this.energy = energy;
    }

    @Override
    public Item copy() {
        return null;
    }
}