package StrdewValley.Models.Enums;

public enum Tools {
    HOE(new CellKind[]{CellKind.SOIL}),
    PICKAXE(new CellKind[]{CellKind.MINE, CellKind.STONE}),
    AXE(new CellKind[]{CellKind.TREE}),
    WATERING_CAN(new CellKind[]{CellKind.PLOW});         //TODO
    private final CellKind[] cellWork;

    Tools(CellKind[] cellWork) {
        this.cellWork = cellWork;
    }
}
