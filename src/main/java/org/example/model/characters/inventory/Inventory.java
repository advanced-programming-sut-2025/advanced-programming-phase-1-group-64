package org.example.model.characters.inventory;

import org.example.model.items.Item;
import org.example.model.items.tools.Tool;
import org.example.model.items.tools.ToolFactory;
import org.example.model.items.tools.quality.ToolQuality;

import java.util.HashMap;

public class Inventory {
    private BackpackQuality quality;
    private TrashQuality trash;
    private HashMap<Item, Integer> items;

    public Inventory() {
        this.quality = BackpackQuality.BASIC;
        this.trash = TrashQuality.BASIC;
        this.items = new HashMap<>();
        this.items.put(ToolFactory.makeHoe(), 1);
        this.items.put(ToolFactory.makePickaxe(), 1);
        this.items.put(ToolFactory.makeAxe(), 1);
        this.items.put(ToolFactory.makeWateringCan(), 1);
        this.items.put(ToolFactory.makeScythe(), 1);
    }
}