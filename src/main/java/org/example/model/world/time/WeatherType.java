package org.example.model.world.time;

import java.util.Arrays;

public enum WeatherType {
    SUNNY("Sunny", SeasonType.SPRING, SeasonType.SUMMER, SeasonType.FALL, SeasonType.WINTER),
    RAIN("Rainy", SeasonType.SPRING, SeasonType.SUMMER, SeasonType.FALL),
    STORM("Storm", SeasonType.SPRING, SeasonType.SUMMER, SeasonType.FALL),
    SNOW("Snow", SeasonType.WINTER);

    private final String name;
    private final SeasonType[] seasons;

    WeatherType(String name, SeasonType... seasons) {
        this.name = name;
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

    public String getName() {return this.name;}

    public static WeatherType getWeatherOfName(String name) {
        return switch (name){
            case "Sunny" -> SUNNY;
            case "Rain" -> RAIN;
            case "Storm" -> STORM;
            case "Snow" -> SNOW;
            default -> null;
        };
    }
}