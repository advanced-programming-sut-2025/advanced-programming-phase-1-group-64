package org.example.model.world;

public enum CellKind {
    EMPTY('.', "Empty Cell"),
    GRASS('*', "Grass Cell"),
    PLOW('+', "Plowed Cell"),
    PLANT('~', "Plant Cell"),
    WOOD('W', "Wood Cell"),
    TREE ('T', "Tree"),
    BURNED_TREE('B', "Burned Tree"),
    ROCK ('R', "Rock"),
    LAKE('L', "Water"),
    GREENHOUSE('G', "Green House"),
    HOME('H', "Home"),
    MINE('M', "Mine"),
    WALK('-', "Street Between Farms"),
    VILLAGE('V', "Village");

    private char cellChar;
    private String cellName;
    private Object object;

    CellKind(char cellChar, String cellName) {
        this.cellChar = cellChar;
        this.cellName = cellName;
    }

    public char getCellChar() {
        return cellChar;
    }

    public String getCellName() {
        return cellName;
    }

    public boolean canHoldObject() {
        return this == TREE || this == ROCK || this == MINE || this == PLANT || this == WOOD;
    }
}