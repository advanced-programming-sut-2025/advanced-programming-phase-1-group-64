package org.example.model.items.foragings;

import org.example.model.items.Item;
import org.example.model.world.time.SeasonType;

import java.util.EnumSet;

public final class WildCrop extends Item {
    private final EnumSet<SeasonType> seasons;
    private final int energy;

    public WildCrop(String name, int basePrice, EnumSet<SeasonType> seasons, int energy) {
        super(name, basePrice);
        this.seasons = seasons;
        this.energy = energy;
    }
}
