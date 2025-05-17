package org.example.model.items.craftings;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.craftings.machines.Machine;

public class MysticTreeSeed extends CraftingItem {
    protected MysticTreeSeed(String name, int basePrice, AbilityType abilitySource, int levelSource, boolean canCraft) {
        super("Mystic Tree Seed", 100, AbilityType.FORAGING, 4);
    }
}