package StrdewValley.Models;

import StrdewValley.Models.Enums.AbilityType;

public class Ability {
    private AbilityType abilityType;
    private int level;
    private int point;
    private boolean isMax;

    public Ability(AbilityType abilityType) {
        this.abilityType = abilityType;
        this.level = 0;
        this.point = 0;
        this.isMax = false;
    }
}