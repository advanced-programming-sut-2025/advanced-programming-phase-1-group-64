package StrdewValley.Models.Animals;

import StrdewValley.Models.Enums.SeasonType;

public enum FishType {
    SALMON(new Fish("Salmon",75, SeasonType.FALL,false));

    private final Fish fish;

    FishType(Fish fish) {
        this.fish = fish;
    }
}
