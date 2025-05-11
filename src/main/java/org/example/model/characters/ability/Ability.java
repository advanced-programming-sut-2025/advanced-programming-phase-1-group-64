package org.example.model.characters.ability;

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
}