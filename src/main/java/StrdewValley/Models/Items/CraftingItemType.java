package StrdewValley.Models.Items;

public enum CraftingItemType {
    CHERRY_BOMB(new CraftingItem("Cherry Bomb", new ));

    private final CraftingItem craftingItem;

    CraftingItemType(CraftingItem craftingItem) {
        this.craftingItem = craftingItem;
    }
}
