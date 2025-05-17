package org.example.model.items.craftings.bombs;

public enum BombType {
    CHERRY("Cherry Bomb",3,1),
    STANDARD("Bomb",5,2),
    MEGA("Mega Bomb",7,3);

    private final String name;
    private final int radius;
    private final int levelSource;

    BombType(String name, int radius, int levelSource) {
        this.name = name;
        this.radius = radius;
        this.levelSource = levelSource;
    }

    public String getName() {return name;}
    public int getRadius() {return radius;}
    public int getLevelSource() {return levelSource;}
}