package StrdewValley.Models.Items.CrafingItems;

import StrdewValley.Models.Items.Item;

import java.util.Map;

public class Recipe {
    private String itemName;
    private Map<Item, Integer> requiredMaterials;

    public Recipe(String itemName, Map<Item, Integer> requiredMaterials) {
        this.itemName = itemName;
        this.requiredMaterials = requiredMaterials;
    }

    public String getItemName() {
        return itemName;
    }

    public Map<Item, Integer> getRequiredMaterials() {
        return requiredMaterials;
    }

    public boolean canCraft(Map<Item, Integer> availableMaterials) {
        for (Map.Entry<Item, Integer> entry : requiredMaterials.entrySet()) {
            if (availableMaterials.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
