package org.example.model.characters.inventory;

import org.example.model.items.Item;
import org.example.model.items.tools.quality.ToolQuality;

import java.util.HashMap;

public class Inventory {
    private BackpackQuality quality;
    private TrashQuality trash;
    private HashMap<Item, Integer> items;
}