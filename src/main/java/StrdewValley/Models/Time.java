package StrdewValley.Models;

import StrdewValley.Models.Enums.GameTime;
import StrdewValley.Models.Enums.SeasonType;

public class Time {
    private int pastHours;

    public Time() {
        this.pastHours = 9;
    }
    public Time(int hour) {
        this.pastHours = hour;
    }

    //TODO: write functions

    public void addHour(int hour){
        this.pastHours += hour;
    }

    public void addDay(int day){
        this.pastHours += (GameTime.HOURS_PER_DAY.getValue() * day);
    }

    public int getDay(){

    }

    public SeasonType getSeasonType(){

    }
}