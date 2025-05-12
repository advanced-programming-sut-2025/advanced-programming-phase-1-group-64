package org.example.model.world;

public enum CellKind {
    EMPTY(' ', "Empty Cell"),
    TREE ('T', "Tree"),
    ROCK ('R', "Rock"),
    WATER ('W', "Water"),
    GREENHOUSE('G', "Green House"),
    HOME('H', "Home"),
    MINE('M', "Mine"),
    WALK('-', "Street Between Farms"),
    VILLAGE('V', "Village"),
    FARM('+', "Empty Cell In Farm"),
    FORAGING('F', "Foraging");

    private char cellChar;
    private String cellName;
    private Object object;

    CellKind(char cellChar, String cellName) {
        this.cellChar = cellChar;
        this.cellName = cellName;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public char getCellChar() {
        return cellChar;
    }

    public String getCellName() {
        return cellName;
    }

    public boolean canHoldObject() {
        return this == TREE || this == FORAGING || this == ROCK;
    }
}