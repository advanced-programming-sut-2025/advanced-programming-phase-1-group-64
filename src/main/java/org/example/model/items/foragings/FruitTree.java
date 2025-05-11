package org.example.model.items.foragings;

import org.example.model.items.Item;
import org.example.model.world.time.SeasonType;

import java.util.EnumSet;
import java.util.List;

public final class FruitTree extends Item {
    private final List<Integer> stages;
    private final EnumSet<SeasonType> seasons;
    private final String fruit;
    private final int fruitSell;
    private final int regrowDays;
}
