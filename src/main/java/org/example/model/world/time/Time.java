package org.example.model.world.time;

public class Time {
    private int elapsedHours;

    public static final int START_HOUR = 9;
    public static final int HOURS_PER_DAY = 14;
    public static final int DAYS_PER_SEASON = 28;

    public int getHourOfDay(){}
    public int getDayIndex(){}
    public int getDayOfWeek(){}
    public SeasonType getSeason(){}

    public void advanceHours(int hours){}
    public void advanceDays(int days){}
}