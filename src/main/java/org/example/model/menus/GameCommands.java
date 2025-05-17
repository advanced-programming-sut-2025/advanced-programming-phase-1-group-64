package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameCommands implements Command {
    NEXT("next turn"),
    TIME("time"),
    DATE("date"),
    DATETIME("datetime"),
    DAY_WEEK("day of the week"),
    CHEAT_TIME("cheat advance time (?<X>\\d+)h"),
    CHEAT_DATE("cheat advance date (?<X>\\d+)d"),
    SEASON("season"),
    CHEAT_THOR("cheat Thor -l <(?<X>\\d+),(?<Y>\\d+)>"),
    WEATHER("weather"),
    WEATHER_FORECAST("weather forecast"),
    CHEAT_WEATHER("cheat weather set (?<Type>\\S+)"),
    BUILD_GREEN("greenhouse build"),
    WALK("walk -l <(?<X>\\d+),(?<Y>\\d+)>"),
    ENERGY_SHOW("energy show"),
    CHEAT_SET_ENERGY("energy set -v (?<value>\\d+)"),
    CHEAT_ENERGY(" energy unlimited"),
    INVENTORY_SHOW("inventory show"),
    INVENTORY_TRASH("inventory trash -i (?<name>\\S.*)( -n (?<number>\\d+))?"),
    EQUIP_TOOL(" tools equip (?<tool>\\S.*)"),
    SHOW_TOOL("tools show available"),

    ;

    private final String pattern;

    GameCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(pattern).matcher(input);
        if(matcher.matches())
            return matcher;
        return null;
    }
}
