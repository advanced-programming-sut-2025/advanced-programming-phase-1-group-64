package StrdewValley.Models.Items.Seeds;

import StrdewValley.Models.Enums.SeasonType;

public enum ForagingSeedType {
    JAZZ_SEEDS(new ForagingSeed("Jazz Seeds", new SeasonType[]{SeasonType.SPRING}));
    //TODO

    private final ForagingSeed foragingSeed;

    ForagingSeedType(ForagingSeed foragingSeed) {
        this.foragingSeed = foragingSeed;
    }

    public ForagingSeed getForagingSeed() {
        return foragingSeed;
    }
}