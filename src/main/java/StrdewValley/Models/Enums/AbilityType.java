package StrdewValley.Models.Enums;

public enum AbilityType {
    FARMING(5),
    MINING(10),
    FORAGING(10),
    FISHING(5);

    private final int increasePoint;

    AbilityType(int increasePoint) {
        this.increasePoint = increasePoint;
    }
}