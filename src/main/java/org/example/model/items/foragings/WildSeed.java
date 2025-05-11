package org.example.model.items.foragings;

import org.example.model.items.Item;
import org.example.model.world.time.SeasonType;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public final class WildSeed extends Item {
    private final EnumSet<SeasonType> seasons;
    private final Map<SeasonType, List<String>> mixed;

    public WildSeed(String name,int basePrice,EnumSet<SeasonType> seasons) {
        super(name, basePrice);
        this.seasons = seasons.clone();
        this.mixed = Map.of();
    }

    public static WildSeed mixed(String name, int price,
                                 Map<SeasonType,List<String>> mixedSeed){
        WildSeed seed = new WildSeed(name,price,EnumSet.allOf(SeasonType.class));
        seed.mixed.putAll(mixedSeed);
        return seed;
    }
}
