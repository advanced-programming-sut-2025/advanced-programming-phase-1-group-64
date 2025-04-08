package StrdewValley.Models;

public class Time {
    private int hour;

    public Time() {
        this.hour = 9;
    }

    public void addHour(int hour){
        this.hour += hour;
    }

    public void addDay(int day){
        this.hour += day * 1;
    }
}
