package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;

public class ForagingCrop extends Item{
    private SeasonType[] season;
    private int baseSellPrice;
    private int energy;

    public ForagingCrop(String name, SeasonType[] season, int baseSellPrice, int energy) {
        super(name);
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
    }
}