package org.example.model.items.trees;

import org.example.model.world.time.SeasonType;

import java.util.EnumSet;

public final class TreeSpec {
    private final String name;
    private final String sourceName;
    private final int[] stages;
    private final int totalHarvestTime;
    private final String fruit;
    private final int fruitHarvestCycle;
    private final int fruitBaseSellPrice;
    private final boolean edible;
    private final Integer energy;
    private final EnumSet<SeasonType> seasons;

    public TreeSpec(String name, String sourceName, int[] stages,
                    int totalHarvestTime, String fruit,
                    int fruitHarvestCycle, int fruitBaseSellPrice,
                    boolean edible, Integer energy,
                    EnumSet<SeasonType> seasons) {
        this.name = name;
        this.sourceName = sourceName;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruit = fruit;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.fruitBaseSellPrice = fruitBaseSellPrice;
        this.edible = edible;
        this.energy = energy;
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return "T";
    }
}