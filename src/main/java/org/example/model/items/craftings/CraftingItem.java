package org.example.model.items.craftings;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.Item;

public abstract class CraftingItem extends Item {
    private final AbilityType abilitySource;
    private final int levelSource;

    protected CraftingItem(String name, int basePrice,
                           AbilityType abilitySource,
                           int levelSource) {
        super(name, basePrice);
        this.abilitySource = abilitySource;
        this.levelSource = levelSource;
    }

    public AbilityType getAbilitySource() {
        return abilitySource;
    }
    public int getLevelSource() {
        return levelSource;
    }
}