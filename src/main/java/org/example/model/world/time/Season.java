package org.example.model.world.time;

import java.util.concurrent.ThreadLocalRandom;

public class Season {
    private SeasonType season;
    private WeatherType today;
    private WeatherType tomorrow;

    public Season(Time time) {
        this.season = time.getSeason();
        this.today = predictWeather();
    }

    public WeatherType predictWeather() {
        WeatherType[] weathersOfThisSeason = WeatherType.getWeatherOfSeason(this.season);

        int idx = ThreadLocalRandom.current().nextInt(weathersOfThisSeason.length);
        return weathersOfThisSeason[idx];
    }
}