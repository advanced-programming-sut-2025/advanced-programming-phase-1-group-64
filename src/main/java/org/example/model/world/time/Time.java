package org.example.model.world.time;

import org.example.model.context.Game;

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
        int remainingHours = HOURS_PER_DAY - (elapsedHours%HOURS_PER_DAY);
        if (hours > remainingHours) {
            throw new IllegalArgumentException("Hours cannot be greater than " + remainingHours);
        }
        this.elapsedHours += hours;
        // تابع های ساعتی
        //TODO
    }
    public void advanceDays(int days){
        if (days < 0) {
            throw new IllegalArgumentException("Days cannot be negative");
        }
        int remainingHours = HOURS_PER_DAY - (elapsedHours%HOURS_PER_DAY);
        advanceHours(remainingHours);
        this.elapsedHours += days * HOURS_PER_DAY;
    }

    public void nextHours(Game g) {
        elapsedHours++;
        // تابع های ساعتی
        if(elapsedHours % HOURS_PER_DAY == 0){
            // تابع های روزانه + // تابع های ساعتی
            g.getSeason().setToday(Season.predictWeather());
            if(g.getSeason().getTomorrow() != null) {
                g.getSeason().setToday(g.getSeason().getTomorrow());
                g.getSeason().setTomorrow(null);
            }
            if(g.getSeason().getToday() == WeatherType.STORM)
                g.getSeason().thor();
        }
    }
}