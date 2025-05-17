package org.example.model.world.time;

import java.util.EnumSet;

public enum SeasonType {
    SPRING("Spring"),
    SUMMER("Summer"),
    FALL("Fall"),
    WINTER("Winter");

    private final String name;

    SeasonType(String name) {
        this.name = name;
    }

    public static EnumSet<SeasonType> parseList(String cell){
        EnumSet<SeasonType> set = EnumSet.noneOf(SeasonType.class);
        for(String part : cell.split("&")){
            set.add(SeasonType.valueOf(part.trim().toUpperCase()));
        }
        return set;
    }

    public String getName() { return this.name; }
}