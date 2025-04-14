package StrdewValley.Models.Items.Seeds;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Items.Item;

import java.util.ArrayList;

public class MixedSeed extends Seed {
    private ForagingSeed[] foragingSeeds;

    public MixedSeed(String name, SeasonType[] seasonTypes, ForagingSeed[] foragingSeeds) {
        super(name,0,seasonTypes);
        this.foragingSeeds = foragingSeeds;
    }

    @Override
    public Item copy() {
        return null;
    }
}