package org.example.model.items.tools;

import org.example.config.ToolConfig;
import org.example.model.items.tools.action.*;
import org.example.model.items.tools.quality.FishingQuality;
import org.example.model.items.tools.quality.ToolQuality;

public final class ToolFactory {
    private ToolFactory() {}

    public static Tool makeHoe(){         return new Tool(0, ToolConfig.getToolSpec("Hoe"),        new HoeAction(),        ToolQuality.BASIC);}
    public static Tool makePickaxe(){     return new Tool(0, ToolConfig.getToolSpec("Pickaxe"),    new PickaxeAction(),    ToolQuality.BASIC);}
    public static Tool makeAxe(){         return new Tool(0, ToolConfig.getToolSpec("Axe"),        new AxeAction(),        ToolQuality.BASIC);}
    public static Tool makeWateringCan(){ return new Tool(0, ToolConfig.getToolSpec("WateringCan"),new WateringCanAction(),ToolQuality.BASIC);}
    public static Tool makeFishingPole(){ return new Tool(0, ToolConfig.getToolSpec("FishingPole"),new FishingPoleAction(),FishingQuality.TRAINING);}
    public static Tool makeScythe(){      return new Tool(0, ToolConfig.getToolSpec("Scythe"),     new ScytheAction(),     ToolQuality.BASIC);}
    public static Tool makeMilkPail(){    return new Tool(0, ToolConfig.getToolSpec("MilkPail"),   new MilkPailAction(),   ToolQuality.BASIC);}
    public static Tool makeShear(){       return new Tool(0, ToolConfig.getToolSpec("Shear"),      new ShearAction(),      ToolQuality.BASIC);}
}