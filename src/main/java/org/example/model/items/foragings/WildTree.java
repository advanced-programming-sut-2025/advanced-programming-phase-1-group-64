package org.example.model.items.foragings;

import org.example.model.items.Item;
import org.example.model.world.time.SeasonType;

import java.util.EnumSet;

public final class WildTree extends Item {
    private final EnumSet<SeasonType> seasons;
    private final String fruit;
    private final int fruitPrice;

    public WildTree(String name, int basePrice,
                       EnumSet<SeasonType> seasons,
                       String fruit, int fruitPrice) {
        super(name, basePrice);
        this.seasons = seasons.clone();
        this.fruit = fruit;
        this.fruitPrice = fruitPrice;
    }
}
