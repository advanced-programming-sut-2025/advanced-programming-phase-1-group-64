package org.example.model.characters.ability;

import org.example.model.items.craftings.CraftingRegistry;

import java.util.List;
import java.util.Map;

public class Ability {
    private AbilityType ability;
    private int level;
    private int xp;
    private boolean isMax;

    public Ability(AbilityType ability) {
        this.ability = ability;
        this.level = 0;
        this.xp = 0;
        this.isMax = false;
    }

    public void addXp(int xp) {
        if (isMax) return;
        this.xp += xp;
        if(xp >= ((100*level) + 50)) {
            xp -= ((100*level) + 50);
            level++;
            if(level == 4)
                isMax = true;
            //Unlock Recipe //TODO
        }
    }

    public boolean isMax() {
        return isMax;
    }
    public AbilityType getAbility() {
        return ability;
    }
}