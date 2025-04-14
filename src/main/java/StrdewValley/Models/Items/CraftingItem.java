package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.AbilityType;

public class CraftingItem extends Item{
    private Item item;
    private AbilityType abilityType;
    private int sellPrice;

    public CraftingItem(String name, Item item, AbilityType abilityType, int sellPrice) {
        super(name);
        this.item = item;
        this.abilityType = abilityType;
        this.sellPrice = sellPrice;
    }
}