package org.example.model.world.time;

import org.example.model.world.Cell;

import java.util.concurrent.ThreadLocalRandom;

public class Season {
    private static SeasonType season;
    private WeatherType today;
    private WeatherType tomorrow;

    public Season(Time time) {
        this.season = time.getSeason();
        this.today = predictWeather();
        this.tomorrow = null;
    }

    public static WeatherType predictWeather() {
        WeatherType[] weathersOfThisSeason = WeatherType.getWeatherOfSeason(season);

        int idx = ThreadLocalRandom.current().nextInt(weathersOfThisSeason.length);
        return weathersOfThisSeason[idx];
    }

    public void thor(int x, int y){
        //TODO
    }
    public void thor(){
        //TODO
    }
    public WeatherType getToday() {return today;}
    public void setToday(WeatherType today) {this.today = today;}
    public void setTomorrow(WeatherType tomorrow) {this.tomorrow = tomorrow;}
    public WeatherType getTomorrow() {return tomorrow;}
}