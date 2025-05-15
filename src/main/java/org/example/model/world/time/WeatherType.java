package org.example.model.world.time;

import java.util.Arrays;

public enum WeatherType {
    SUNNY(SeasonType.SPRING, SeasonType.SUMMER, SeasonType.FALL, SeasonType.WINTER),
    RAIN(SeasonType.SPRING, SeasonType.SUMMER, SeasonType.FALL),
    STORM(SeasonType.SPRING, SeasonType.SUMMER, SeasonType.FALL),
    SNOW(SeasonType.WINTER);

    private final SeasonType[] seasons;

    WeatherType(SeasonType... seasons) {
        this.seasons = seasons;
    }

    public SeasonType[] getSeasons() {
        return seasons;
    }

    public static WeatherType[] getWeatherOfSeason(SeasonType season) {
        return Arrays.stream(values())
                .filter(w -> Arrays
                        .asList(w.seasons)
                        .contains(season))
                .toArray(WeatherType[]::new);
    }
}