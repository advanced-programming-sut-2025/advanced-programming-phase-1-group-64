package org.example.model.world.time;

public class Time {
    private int elapsedHours;

    public static final int START_HOUR = 9;
    public static final int HOURS_PER_DAY = 14;
    public static final int DAYS_PER_SEASON = 28;
    public static final int SEASON_CYCLE_HOURS = DAYS_PER_SEASON * HOURS_PER_DAY;


    public Time() {
        this.elapsedHours = 0;
    }

    public int getHourOfDay(){
        return START_HOUR + (elapsedHours % HOURS_PER_DAY);
    }
    public int getDayIndex(){
        return (elapsedHours / HOURS_PER_DAY % DAYS_PER_SEASON) + 1;
    }
    public int getDayOfWeek(){
        return (elapsedHours / HOURS_PER_DAY % 7) + 1;
    }
    public SeasonType getSeason(){
        int totalSeasons = SeasonType.values().length;
        int seasonIndex = (elapsedHours / SEASON_CYCLE_HOURS) % totalSeasons;
        return SeasonType.values()[seasonIndex];
    }

    public void advanceHours(int hours){
        if (hours < 0) {
            throw new IllegalArgumentException("Hours cannot be negative");
        }
        this.elapsedHours += hours;
    }
    public void advanceDays(int days){
        if (days < 0) {
            throw new IllegalArgumentException("Days cannot be negative");
        }
        this.elapsedHours += days * HOURS_PER_DAY;
    }
}