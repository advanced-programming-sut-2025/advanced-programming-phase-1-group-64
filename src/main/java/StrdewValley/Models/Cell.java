package StrdewValley.Models;

import StrdewValley.Models.Enums.CellKind;
import StrdewValley.Models.Items.Item;

public class Cell {
    private int x;
    private int y;
    private CellKind cellKind;
    private Item item;

    public Cell(int x, int y, CellKind cellKind, Item item) {
        this.x = x;
        this.y = y;
        this.cellKind = cellKind;
        this.item = item;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellKind getCellKind() {
        return cellKind;
    }

    public Item getItem() {
        return item;
    }

    public void setCellKind(CellKind cellKind) {
        this.cellKind = cellKind;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}