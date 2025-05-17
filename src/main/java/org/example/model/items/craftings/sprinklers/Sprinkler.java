package org.example.model.items.craftings.sprinklers;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.craftings.CraftingItem;

public class Sprinkler extends CraftingItem {
    private final SprinklerType type;

    public Sprinkler(SprinklerType type) {
        super(type.getName(), 0, AbilityType.FARMING, type.getLevelSource());
        this.type = type;
    }
}