package org.example.model.items.craftings.machines;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.Item;

import java.util.List;

public class Furnace extends Machine{

    public Furnace(String name, int basePrice, AbilityType abilitySource, int levelSource, boolean canCraft, List<MachineRecipe> recipes) {
        super("Furnace", 0, null, 0, true, recipes);
    }

    @Override
    public Item outputFor(Item input) {
        return null;
    }
}
