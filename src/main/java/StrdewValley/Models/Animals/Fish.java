package StrdewValley.Models.Animals;

import StrdewValley.Models.Enums.SeasonType;

public class Fish {
    private String name;
    private int sellPrice;
    private SeasonType season;
    private boolean isLegendary;

    public Fish(String name, int sellPrice, SeasonType season, boolean isLegendary) {
        this.name = name;
        this.sellPrice = sellPrice;
        this.season = season;
        this.isLegendary = isLegendary;
    }
}
