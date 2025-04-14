package StrdewValley.Models.Items.Tools;

import StrdewValley.Models.Enums.CellKind;
import StrdewValley.Models.Enums.Quality;

public enum ToolTypes {
    HOE(new Tool("Hoe", 0, Quality.NORMAL, new CellKind[]{CellKind.SOIL})),
    PICKAXE(new CellKind[]{CellKind.MINE, CellKind.STONE}),
    AXE(new CellKind[]{CellKind.TREE}),
    WATERING_CAN(new CellKind[]{CellKind.PLOW});         //TODO

    private final Tool tool;

    ToolTypes(Tool tool) {
        this.cellWork = tool;
    }
}
