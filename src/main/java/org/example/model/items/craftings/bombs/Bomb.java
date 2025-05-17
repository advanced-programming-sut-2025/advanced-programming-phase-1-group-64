package org.example.model.items.craftings.bombs;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.craftings.CraftingItem;

public class Bomb extends CraftingItem {
    private final BombType type;

    public Bomb(BombType type) {
        super(type.getName(), 50, AbilityType.MINING, type.getLevelSource());
        this.type = type;
    }
}