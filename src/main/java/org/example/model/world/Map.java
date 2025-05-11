package org.example.model.world;

import org.example.model.characters.Player;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    private final int width = 50;
    private final int height = 30;

    private Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }

    public static Map createMap(Player player1, int type1, Player player2, int type2)
    {
        Map map = new Map();
        map.cells = new Cell[map.height][map.width];

        for (int y = 0; y < map.height; y++) {
            for (int x = 0; x < map.width; x++) {
                map.cells[y][x] = new Cell(x, new ArrayList<>(), CellKind.EMPTY, y);
            }
        }

        for (int y = 0; y < map.height; y++) {
            for (int x = 0; x < map.width; x++) {
                ArrayList<Player> accessPlayers = new ArrayList<>();
                CellKind kind = map.cells[y][x].getKind();

                if (x < 20 && y < 10) {
                    accessPlayers.add(player1);
                    kind = CellKind.FARM;
                }
                else if (x >= map.width - 20 && y < 10) {
                    accessPlayers.add(player2);
                    kind = CellKind.FARM;
                }
                else if (x >= 20 && x < 30 && y < 10) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player2);
                    kind = CellKind.WALK;
                }
                else if (x >= 20 && x < 30 && y >= 10 && y < 20) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player2);
                    kind = CellKind.VILLAGE;
                }

                map.cells[y][x] = new Cell(x, accessPlayers, kind, y);
            }

            createFarmMap(0, 0, type1, map.cells);
            createFarmMap(map.width - 20,  0, type2, map.cells);
        }

        return map;
    }

    private static void createFarmMap(int startX, int startY, int type, Cell[][] cells) {
        if (type == 1) {
            // خانه 4x4 در بالا سمت چپ
            for (int y = startY; y < startY + 4; y++) {
                for (int x = startX; x < startX + 4; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.HOME);
                    }
                }
            }

            // گلخانه 6x5 در سمت راست خانه
            int greenhouseStartX = startX + 15;
            int greenhouseStartY = startY;
            for (int y = greenhouseStartY; y < greenhouseStartY + 6; y++) {
                for (int x = greenhouseStartX; x < greenhouseStartX + 5; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.GREENHOUSE);
                    }
                }
            }

            // معدن 4x5 در پایین سمت چپ
            int mineStartX = startX;
            int mineStartY = startY + 4;
            for (int y = mineStartY; y < mineStartY + 6; y++) {
                for (int x = mineStartX; x < mineStartX + 4; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.MINE);
                    }
                }
            }

            // دریاچه 3x5 در پایین سمت راست
            int lakeStartX = startX + 15;
            int lakeStartY = startY + 6;
            for (int y = lakeStartY; y < lakeStartY + 4; y++) {
                for (int x = lakeStartX; x < lakeStartX + 5; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.WATER);
                    }
                }
            }
        }
        else if (type == 2) {
            int lake1StartX = startX;
            int lake1StartY = startY;
            for (int y = lake1StartY; y < lake1StartY + 3; y++) {
                for (int x = lake1StartX; x < lake1StartX + 4; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.WATER);
                    }
                }
            }

            int mineStartX = startX + 15;
            int mineStartY = startY;
            for (int y = mineStartY; y < mineStartY + 4; y++) {
                for (int x = mineStartX; x < mineStartX + 5; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.MINE);
                    }
                }
            }

            int homeStartX = startX;
            int homeStartY = startY + 3;
            for (int y = homeStartY; y < homeStartY + 4; y++) {
                for (int x = homeStartX; x < homeStartX + 4; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.HOME);
                    }
                }
            }

            int greenhouseStartX = startX + 15;
            int greenhouseStartY = startY + 4;
            for (int y = greenhouseStartY; y < greenhouseStartY + 6; y++) {
                for (int x = greenhouseStartX; x < greenhouseStartX + 5; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.GREENHOUSE);
                    }
                }
            }

            int lake2StartX = startX;
            int lake2StartY = startY + 7;
            for (int y = lake2StartY; y < lake2StartY + 3; y++) {
                for (int x = lake2StartX; x < lake2StartX + 4; x++) {
                    if (y < cells.length && x < cells[0].length) {
                        cells[y][x].setKind(CellKind.WATER);
                    }
                }
            }
        }

        fillCenterArea(cells, 4, 0, 11, 10);
    }

    private static void fillCenterArea(Cell[][] cells, int startX, int startY, int width, int height) {
        Random random = new Random();

        for (int y = startY; y < startY + height && y < cells.length; y++) {
            for (int x = startX; x < startX + width && x < cells[0].length; x++) {
                if (cells[y][x].getKind() == CellKind.FARM) {
                    double chance = random.nextDouble();

                    if (chance < 0.3) {
                        //double typeChance = random.nextDouble();

                        if (chance < 0.33) { // 33% از 30% = 10% کل
                            cells[y][x].setKind(CellKind.TREE);
                        }
//                        else if (typeChance < 0.66) { // 33% از 30% = 10% کل
//                            cells[y][x].setKind(CellKind.ROCK);
//                        }
//                        else { // 34% از 30% ≈ 10% کل
//                            cells[y][x].setKind(CellKind.FORAGING);
//                        }
                    }
                }
            }
        }
    }

    public String printMap(int x, int y, int size) {
        StringBuilder mapOutput = new StringBuilder();

        // محاسبه محدوده قابل نمایش با در نظر گرفتن مرزهای نقشه
        int startX = Math.max(0, x);
        int startY = Math.max(0, y);
        int endX = Math.min(width, x + size);
        int endY = Math.min(height, y + size);

        // ایجاد خط بالای کادر
        mapOutput.append("+");
        for (int i = startX; i < endX; i++) {
            mapOutput.append("---");
        }
        mapOutput.append("-+\n");

        // چاپ هر سطر از نقشه
        for (int row = startY; row < endY; row++) {
            mapOutput.append("| ");
            for (int col = startX; col < endX; col++) {
                // دریافت کاراکتر مربوط به نوع سلول
                char cellChar = cells[row][col].getKind().getCellChar();
                mapOutput.append(cellChar).append("  ");
            }
            mapOutput.append("|\n");
        }

        // ایجاد خط پایین کادر
        mapOutput.append("+");
        for (int i = startX; i < endX; i++) {
            mapOutput.append("---");
        }
        mapOutput.append("-+");

        return mapOutput.toString();
    }

    public String helpReadingMap() {
        StringBuilder helpText = new StringBuilder();
        helpText.append("Map Legend:\n");
        helpText.append("-----------\n");

        for (CellKind cellKind : CellKind.values()) {
            helpText.append(String.format("%c: %s%n",
                    cellKind.getCellChar(),
                    cellKind.getCellName()));
        }

        return helpText.toString();
    }

    private Boolean isCellCompleted(Cell cell)
    {
         for(Cell[] c : cells){
             for (Cell cc : c) {
                 if (cc.equals(cell)) {
                     return true;
                 }
             }
         }
         return false;
    }

}