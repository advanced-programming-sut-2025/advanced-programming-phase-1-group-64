package org.example.model.items.craftings.scarecrows;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.craftings.CraftingItem;

public class Scarecrow extends CraftingItem {
    private final ScarecrowType type;

    public Scarecrow(ScarecrowType type) {
        super(type.getName(), 0, AbilityType.FARMING, type.getLevelSource());
        this.type = type;
    }
}