package org.example.model.items.craftings.machines;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.Item;

import java.util.List;

public class CharcoalKlin extends Machine{

    public CharcoalKlin(List<MachineRecipe> recipes) {
        super("Charcoal Klin", 0, AbilityType.FORAGING, 1, false, recipes);
    }

    @Override
    public Item outputFor(Item input) {
        return null;
    }
}
