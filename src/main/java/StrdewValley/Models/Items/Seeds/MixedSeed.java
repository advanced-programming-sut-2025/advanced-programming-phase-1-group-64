package StrdewValley.Models.Items.Seeds;

import StrdewValley.Models.Enums.SeasonType;

import java.util.ArrayList;

public class MixedSeed extends Seed {
    private ForagingSeed[] foragingSeeds;

    public MixedSeed(String name, SeasonType[] seasonTypes, ForagingSeed[] foragingSeeds) {
        super(name, seasonTypes);
        this.foragingSeeds = foragingSeeds;
    }
}