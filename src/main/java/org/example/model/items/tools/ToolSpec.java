package org.example.model.items.tools;

import org.example.model.items.tools.quality.FishingQuality;
import org.example.model.items.tools.quality.ToolQuality;

import java.util.EnumMap;

public class ToolSpec {
    private final String name;
    private final EnumMap<ToolQuality,Integer> energy;
    private final EnumMap<FishingQuality,Integer> energyFishing;
    private final EnumMap<ToolQuality,Integer> capacity;

    public ToolSpec(String name,
                    EnumMap<ToolQuality, Integer> energy,
                    EnumMap<FishingQuality, Integer> energyFishing,
                    EnumMap<ToolQuality, Integer> capacity) {
        this.name = name;
        this.energy = energy;
        this.energyFishing = energyFishing;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }
    public int getEnergyCost(ToolQuality quality){return energy.get(quality);}
    public int getEnergyCost(FishingQuality quality){return energyFishing.get(quality);}
    public EnumMap<ToolQuality, Integer> getCapacity() {
        return capacity;
    }
}