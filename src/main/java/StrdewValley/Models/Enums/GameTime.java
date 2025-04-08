package StrdewValley.Models.Enums;

public enum GameTime {
    HOURS_PER_DAY(9),
    DAYS_PER_SEASON(28),
    

    private final int valueByHour;

    GameTime(int valueByHour) {
        this.valueByHour = valueByHour;
    }
}
