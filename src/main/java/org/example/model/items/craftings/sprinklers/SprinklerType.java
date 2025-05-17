package org.example.model.items.craftings.sprinklers;

public enum SprinklerType {
    STANDARD("Sprinkler",4,1),
    QUALITY("Quality Sprinkler",8,2),
    IRIDIUM("Iridium Sprinkler",24,3);

    private final String name;
    private final int tile;
    private final int levelSource;

    SprinklerType(String name, int tile, int levelSource) {
        this.name = name;
        this.tile = tile;
        this.levelSource = levelSource;
    }

    public String getName() {return name;}
    public int getTile() {return tile;}
    public int getLevelSource() {return levelSource;}
}