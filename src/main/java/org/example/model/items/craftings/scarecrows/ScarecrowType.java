package org.example.model.items.craftings.scarecrows;

import org.example.model.characters.ability.AbilityType;

public enum ScarecrowType {
    STANDARD("Scarecrow",8,0),
    DELUXE("Deluxe Scarecrow",12,2);

    private final String name;
    private final int radius;
    private final int levelSource;

    ScarecrowType(String name, int radius, int levelSource) {
        this.name = name;
        this.radius = radius;
        this.levelSource = levelSource;
    }

    public String getName() {return name;}
    public int getRadius() {return radius;}
    public int getLevelSource() {return levelSource;}
}
