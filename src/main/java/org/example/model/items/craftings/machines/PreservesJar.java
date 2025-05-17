package org.example.model.items.craftings.machines;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.Item;

import java.util.List;

public class PreservesJar extends Machine{
    public PreservesJar(String name, int basePrice, AbilityType abilitySource, int levelSource, boolean canCraft, List<MachineRecipe> recipes) {
        super(name, basePrice, abilitySource, levelSource, canCraft, recipes);
    }

    @Override
    public Item outputFor(Item input) {
        return null;
    }
}
