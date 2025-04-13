package StrdewValley.Models.Enums;

public enum GameTime {
    HOURS_PER_DAY(9),
    DAYS_PER_SEASON(28);
    

    private final int value;

    GameTime(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}