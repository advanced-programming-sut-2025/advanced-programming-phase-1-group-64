package org.example.model.items.craftings;

import org.example.model.characters.ability.AbilityType;

public class GrassStarter extends CraftingItem{
    protected GrassStarter(int basePrice, AbilityType abilitySource, int levelSource) {
        super("Grass Starter", 0, abilitySource, levelSource);
    }
}