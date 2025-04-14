package StrdewValley.Models.Items.CrafingItems;

import StrdewValley.Models.Items.Item;

import java.util.Map;

public class Crafting {
    public static Item craft(Recipe recipe, Map<Item, Integer> availableMaterials){
        if (recipe.canCraft(availableMaterials)) {
            Map<Item, Integer> requiredMaterials = recipe.getRequiredMaterials();
            for (Map.Entry<Item, Integer> entry : requiredMaterials.entrySet()) {
                availableMaterials.put(entry.getKey(), availableMaterials.get(entry.getKey()) - entry.getValue());
            }

            return new Item(recipe.getItemName(), 50) {
                @Override
                public Item copy() {
                    return null;
                }
            };
        } else {
            System.out.println("Not enough materials to craft " + recipe.getItemName());
            return null;
        }
    }
}