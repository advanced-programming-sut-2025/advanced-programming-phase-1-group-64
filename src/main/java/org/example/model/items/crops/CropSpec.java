package org.example.model.items.crops;

import org.example.model.world.time.SeasonType;

import java.util.EnumSet;

public final class CropSpec {
    private final String name;
    private final String sourceName;
    private final int[] stages;
    private final int totalHarvestTime;
    private final boolean oneTime;
    private final Integer regrowthTime;
    private final int baseSellPrice;
    private final boolean edible;
    private final Integer energy;
    private final EnumSet<SeasonType> seasons;
    private final boolean canBecomeGiant;

    public CropSpec(String name, String sourceName, int[] stages,
                    int totalHarvestTime, boolean oneTime, Integer regrowthTime,
                    int baseSellPrice, boolean edible, Integer energy,
                    EnumSet<SeasonType> seasons, boolean canBecomeGiant) {
        this.name = name;
        this.sourceName = sourceName;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.oneTime = oneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.edible = edible;
        this.energy = energy;
        this.seasons = seasons;
        this.canBecomeGiant = canBecomeGiant;
    }

    public String getName() {
        return name;
    }
    public int getBaseSellPrice() {
        return baseSellPrice;
    }
}