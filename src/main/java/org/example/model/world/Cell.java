package org.example.model.world;

import org.example.model.characters.Player;

import java.util.ArrayList;

public class Cell {
    private int x;
    private int y;
    private CellKind kind;
    private ArrayList<Player> haveAccessToThisCellPlayers;
    private Object object;

    public Cell(int x, ArrayList<Player> haveAccessToThisCellPlayers, CellKind kind, int y) {
        this.x = x;
        this.haveAccessToThisCellPlayers = haveAccessToThisCellPlayers;
        this.kind = kind;
        this.y = y;
        this.object = null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CellKind getKind() {
        return kind;
    }

    public void setKind(CellKind kind) {
        this.kind = kind;
    }

    public ArrayList<Player> getHaveAccessToThisCellPlayers() {
        return haveAccessToThisCellPlayers;
    }

    public void setHaveAccessToThisCellPlayers(ArrayList<Player> haveAccessToThisCellPlayers) {
        this.haveAccessToThisCellPlayers = haveAccessToThisCellPlayers;
    }

    public boolean equals(Object object){
        Cell cell = (Cell) object;
        if (this.getX() == cell.getX() && this.getY() == cell.getY()){
            return true;
        }
        return false;
    }

    public static Cell[][] createCellType(int height, int width, CellKind kind, int startY, int startX, Cell[][] cells) {
        for ( int y = startY; y < startY + height; y++) {
            for ( int x = startX; x < startX + width; x++) {
                if (y < cells.length && x < cells[0].length) {
                    cells[y][x].setKind(kind);
                }
            }
        }

        return cells;
    }
}