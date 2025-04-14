package StrdewValley.Models.Items.Seeds;

import StrdewValley.Models.Enums.SeasonType;

public enum MixedSeedType {
    SPRING(new MixedSeed("Spring Mixed", new SeasonType[]{SeasonType.SPRING},
            new ForagingSeed[]{ForagingSeedType.JAZZ_SEEDS.getForagingSeed()}));
    //TODO

    private final MixedSeed mixedSeed;

    MixedSeedType(MixedSeed mixedSeed) {
        this.mixedSeed = mixedSeed;
    }
}