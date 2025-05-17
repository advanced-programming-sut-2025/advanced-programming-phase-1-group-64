package org.example.model.items.craftings.machines;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.Item;
import org.example.model.items.craftings.CraftingItem;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class Machine extends CraftingItem {
    private final List<MachineRecipe> recipes;

    protected Machine(String name, int basePrice,
                      AbilityType abilitySource,
                      int levelSource, boolean canCraft,
                      List<MachineRecipe> recipes) {
        super(name, basePrice, abilitySource, levelSource);
        this.recipes = recipes;
    }

    public List<MachineRecipe> getRecipes() {
        return recipes;
    }

    public Optional<MachineRecipe> matchRecipe(Map<String, Integer> offered) {
        return recipes.stream()
                .filter(r -> offered.entrySet().containsAll(r.getInputs().entrySet()))
                .findFirst();
    }

    public abstract Item outputFor(Item input);
}