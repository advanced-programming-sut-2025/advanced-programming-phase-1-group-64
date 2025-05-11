package org.example.model.world.time;

import java.util.EnumSet;

public enum SeasonType {
    SPRING,
    SUMMER,
    FALL,
    WINTER;

    public static EnumSet<SeasonType> parseList(String cell){
        EnumSet<SeasonType> set = EnumSet.noneOf(SeasonType.class);
        for(String part : cell.split("&")){
            set.add(SeasonType.valueOf(part.trim().toUpperCase()));
        }
        return set;
    }
}