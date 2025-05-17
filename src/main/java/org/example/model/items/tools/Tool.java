package org.example.model.items.tools;

import org.example.model.items.Item;
import org.example.model.items.tools.action.ToolAction;
import org.example.model.items.tools.quality.FishingQuality;
import org.example.model.items.tools.quality.ToolQuality;

public class Tool extends Item {
    private final ToolSpec spec;
    private final ToolAction action;
    private ToolQuality toolQuality;
    private FishingQuality fishingQuality;
    private int waterInPail;

    public Tool(int basePrice, ToolSpec spec,
                ToolAction action, ToolQuality quality) {
        super(spec.getName(), basePrice);
        this.spec = spec;
        this.action = action;
        this.toolQuality = quality;
    }
    public Tool(int basePrice, ToolSpec spec,
                ToolAction action, FishingQuality quality){
        super(spec.getName(), basePrice);
        this.spec = spec;
        this.action = action;
        this.fishingQuality = quality;
    }

    public int getEnergyCost(){ return toolQuality!=null ? spec.getEnergyCost(toolQuality) : spec.getEnergyCost(fishingQuality);}

    public ToolSpec getSpec() {
        return spec;
    }

    public ToolAction getAction() {
        return action;
    }

    public ToolQuality getToolQuality() {
        return toolQuality;
    }

    public void setToolQuality(ToolQuality toolQuality) {
        this.toolQuality = toolQuality;
    }

    public FishingQuality getFishingQuality() {
        return fishingQuality;
    }

    public void setFishingQuality(FishingQuality fishingQuality) {
        this.fishingQuality = fishingQuality;
    }

    public int getWaterInPail() {
        return waterInPail;
    }

    public void setWaterInPail(int waterInPail) {
        this.waterInPail = waterInPail;
    }
}