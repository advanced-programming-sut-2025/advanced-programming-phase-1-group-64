package org.example.model.world;

import org.example.config.TreeConfig;
import org.example.model.characters.Player;
import org.example.model.items.trees.TreeSpec;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Map {
    private final int width = 50;
    private final int height = 30;

    private Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }

    private static Map createEmpty() {
        Map map = new Map();
        map.cells = new Cell[map.height][map.width];

        for ( int y = 0; y < map.height; y++ ) {
            for ( int x = 0; x < map.width; x++ ) {
                map.cells[y][x] = new Cell(x, new ArrayList<>(), CellKind.EMPTY, y);
            }
        }

        return map;
    }

    public static Map createMap(Player player1, int type1, Player player2, int type2)
    {
        Map map = createEmpty();

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
        }

        createFarmMap(0, 0, type1, map.cells, player1);
        createFarmMap(map.width - 20,  0, type2, map.cells, player2);

        return map;
    }

    public static Map createMap(Player player1, int type1, Player player2, int type2, Player player3, int type3)
    {
        Map map = createEmpty();

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
                else if (x < 20 && y >= 20) {
                    accessPlayers.add(player3);
                    kind = CellKind.FARM;
                }
                else if (x >= 20 && x < 30 && y < 10) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player2);
                    kind = CellKind.WALK;
                }
                else if (x < 10 && y < 20 && y >= 10) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player3);
                    kind = CellKind.WALK;
                }
                else if (x >= 20 && x < 30 && y >= 10 && y < 20) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player2);
                    accessPlayers.add(player3);
                    kind = CellKind.VILLAGE;
                }

                map.cells[y][x] = new Cell(x, accessPlayers, kind, y);
            }
        }

        createFarmMap(0, 0, type1, map.cells, player1);
        createFarmMap(map.width - 20,  0, type2, map.cells, player2);
        createFarmMap(0,  20, type3, map.cells, player3);

        return map;
    }

    public static Map createMap(Player player1, int type1, Player player2, int type2, Player player3, int type3,
                                Player player4, int type4)
    {
        Map map = createEmpty();

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
                else if (x < 20 && y >= map.height - 10) {
                    accessPlayers.add(player3);
                    kind = CellKind.FARM;
                }
                else if (x >= map.width - 20 && y >= map.height - 10) {
                    accessPlayers.add(player4);
                    kind = CellKind.FARM;
                }
                else if (x >= 20 && x < 30 && y < 10) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player2);
                    kind = CellKind.WALK;
                }
                else if (x < 10 && y < 20 && y >= 10) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player3);
                    kind = CellKind.WALK;
                }
                else if (x >= 20 && y < 20 && y >= 10) {
                    accessPlayers.add(player2);
                    accessPlayers.add(player4);
                    kind = CellKind.WALK;
                }
                else if (x >= 20 && x < 30 && y >= map.height - 10) {
                    accessPlayers.add(player3);
                    accessPlayers.add(player4);
                    kind = CellKind.WALK;
                }
                else if (x >= 20 && x < 30 && y >= 10 && y < 20) {
                    accessPlayers.add(player1);
                    accessPlayers.add(player2);
                    accessPlayers.add(player3);
                    accessPlayers.add(player4);
                    kind = CellKind.VILLAGE;
                }

                map.cells[y][x] = new Cell(x, accessPlayers, kind, y);
            }
        }

        createFarmMap(0, 0, type1, map.cells, player1);
        createFarmMap(map.width - 20,  0, type2, map.cells, player2);
        createFarmMap(0,  20, type3, map.cells, player3);
        createFarmMap(map.width - 20,  20, type4, map.cells, player4);

        return map;
    }

    private static void createFarmMap(int startX, int startY, int type, Cell[][] cells, Player p) {
        cells[startY][startX].setObject(p);

        if (type == 1) {
            // خانه 4x4 در بالا سمت چپ
            cells = Cell.createCellType(4,4,CellKind.HOME, startY, startX, cells);

            // گلخانه 6x5 در سمت راست خانه
            int greenhouseStartX = startX + 15;
            int greenhouseStartY = startY;
            cells = Cell.createCellType(6,5,CellKind.GREENHOUSE,greenhouseStartY,greenhouseStartX,cells);

            // معدن 4x5 در پایین سمت چپ
            int mineStartX = startX;
            int mineStartY = startY + 4;
            cells = Cell.createCellType(5,4,CellKind.MINE,mineStartY,mineStartX,cells);

            // دریاچه 3x5 در پایین سمت راست
            int lakeStartX = startX + 15;
            int lakeStartY = startY + 6;
            cells = Cell.createCellType(3,5,CellKind.WATER,lakeStartY,lakeStartX,cells);
        }
        else if (type == 2) {
            // دریاچه 4*3
            int lake1StartX = startX;
            int lake1StartY = startY;
            cells = Cell.createCellType(3,4,CellKind.WATER,lake1StartY,lake1StartX,cells);

            // دریاچه 4*3
            int lake2StartX = startX;
            int lake2StartY = startY + 7;
            cells = Cell.createCellType(3,4,CellKind.WATER,lake2StartY,lake2StartX,cells);

            int mineStartX = startX + 15;
            int mineStartY = startY;
            cells = Cell.createCellType(4,5,CellKind.MINE,mineStartY,mineStartX,cells);

            int homeStartX = startX;
            int homeStartY = startY + 3;
            cells = Cell.createCellType(4,4,CellKind.HOME,homeStartY,homeStartX,cells);

            int greenhouseStartX = startX + 15;
            int greenhouseStartY = startY + 4;
            cells = Cell.createCellType(6,5,CellKind.GREENHOUSE,greenhouseStartY,greenhouseStartX,cells);
        }

        fillCenterArea(cells, 4, 0, 11, 10);
    }

    private static void fillCenterArea(Cell[][] cells, int startX, int startY, int width, int height) {
        List<TreeSpec> allTreeTypes = new ArrayList<>(TreeConfig.all());
        if (allTreeTypes.isEmpty()) return;

        List<TreeSpec> placedTrees = new ArrayList<>();

        for (TreeSpec tree : allTreeTypes) {
            boolean placed = false;
            while (!placed) {
                for (int y = startY; y < startY + height && y < cells.length; y++) {
                    for (int x = startX; x < startX + width && x < cells[0].length; x++) {
                        if (cells[y][x].getKind() == CellKind.FARM && Math.random() < 0.01) {
                            cells[y][x].setKind(CellKind.TREE);
                            cells[y][x].getKind().setObject(tree); // ذخیره مشخصات درخت در سلول
                            placedTrees.add(tree);
                            placed = true;
                            break;
                        }
                    }
                    if (placed) break;
                }
            }
        }

        for (int y = startY; y < startY + height && y < cells.length; y++) {
            for (int x = startX; x < startX + width && x < cells[0].length; x++) {
                if (cells[y][x].getKind() == CellKind.FARM) {
                    double random = Math.random();

                    if (random < 0.003) {
                        TreeSpec randomTree = allTreeTypes.get((int)(Math.random() * allTreeTypes.size()));
                        cells[y][x].setKind(CellKind.TREE);
                        cells[y][x].getKind().setObject(randomTree);
                    } else if (random < 0.006) {
                        cells[y][x].setKind(CellKind.ROCK);
                    } else if(random < 0.01) {
                        cells[y][x].setKind(CellKind.FORAGING);
                    }
                }
            }
        }
    }

    public String printMap(int x, int y, int size) {
        StringBuilder mapOutput = new StringBuilder();

        int startX = Math.max(0, x);
        int startY = Math.max(0, y);
        int endX = Math.min(width, x + size);
        int endY = Math.min(height, y + size);

        mapOutput.append("+");
        for (int i = startX; i < endX; i++) {
            mapOutput.append("---");
        }
        mapOutput.append("-+\n");

        for (int row = startY; row < endY; row++) {
            mapOutput.append("| ");
            for (int col = startX; col < endX; col++) {
                Cell cell = cells[row][col];
                char cellChar;

                if (cell.getObject() != null) {
                    cellChar = cell.getObject().toString().charAt(0);
                } else {
                    cellChar = cell.getKind().getCellChar();
                }

                mapOutput.append(cellChar).append("  ");
            }
            mapOutput.append("|\n");
        }

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

    public void walk(int targetX, int targetY, Player p) {
        // پیدا کردن سلول فعلی بازیکن
        Cell currentCell = findPlayerCell(p);
        if (currentCell == null) {
            System.out.println("Error: Player not found on map!");
            return;
        }

        // بررسی آیا مقصد در محدوده مجاز است
        if (!isValidCoordinate(targetX, targetY)) {
            System.out.println("Error: Target coordinates are out of bounds!");
            return;
        }

        Cell targetCell = cells[targetY][targetX];

        // بررسی دسترسی به مزرعه دیگر بازیکنان
        if (!targetCell.getHaveAccessToThisCellPlayers().contains(p)) {
            System.out.println("Error: You don't have access to this player's farm!");
            return;
        }

        // پیدا کردن مسیر با کمترین انرژی
        PathResult pathResult = findShortestPath(currentCell, targetCell, p);
        if (pathResult == null) {
            System.out.println("Error: No valid path to target!");
            return;
        }

        // محاسبه انرژی مورد نیاز
        int energyNeeded = calculateEnergyCost(pathResult.path.size(), pathResult.turns);

        System.out.println("Energy needed: " + energyNeeded);
        System.out.println("Confirm movement? (yes/no)");

        boolean confirmed = true; // در واقعیت باید از کاربر بپرسید

        if (confirmed) {
            if (p.getCurrentEnergy() >= energyNeeded) {
                movePlayer(p, currentCell, targetCell, pathResult.path);
                p.setCurrentEnergy(p.getCurrentEnergy() - energyNeeded);
                System.out.println("Moved successfully! Remaining energy: " + p.getCurrentEnergy());
            } else {
                p.setFainted(true);
                System.out.println("Not enough energy! Player fainted!");
            }
        }
    }

    private Cell findPlayerCell(Player p) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (cells[y][x].getObject() == p) {
                    return cells[y][x];
                }
            }
        }
        return null;
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private int calculateEnergyCost(int distance, int turns) {
        return (distance + 10 * turns) / 20;
    }

    private PathResult findShortestPath(Cell start, Cell end, Player p) {
        PriorityQueue<PathNode> openSet = new PriorityQueue<>();
        java.util.Map<Cell, PathNode> allNodes = new HashMap<>();

        PathNode startNode = new PathNode(start, null, 0, estimateDistance(start, end));
        openSet.add(startNode);
        allNodes.put(start, startNode);

        while (!openSet.isEmpty()) {
            PathNode current = openSet.poll();

            if (current.cell.equals(end)) {
                // مسیر پیدا شد
                List<Cell> path = new ArrayList<>();
                int turns = 0;
                PathNode node = current;

                while (node != null) {
                    path.add(0, node.cell);
                    node = node.parent;
                    turns++;
                }

                return new PathResult(path, turns);
            }

            for (Cell neighbor : getWalkableNeighbors(current.cell, p)) {
                int newCost = current.gCost + 1; // هزینه هر حرکت 1 است

                PathNode neighborNode = allNodes.getOrDefault(neighbor, new PathNode(neighbor));
                allNodes.putIfAbsent(neighbor, neighborNode);

                if (newCost < neighborNode.gCost) {
                    neighborNode.parent = current;
                    neighborNode.gCost = newCost;
                    neighborNode.hCost = estimateDistance(neighbor, end);
                    neighborNode.calculateFCost();

                    if (!openSet.contains(neighborNode)) {
                        openSet.add(neighborNode);
                    }
                }
            }
        }

        return null;
    }

    private static class PathNode implements Comparable<PathNode> {
        public Cell cell;
        public PathNode parent;
        public int gCost;
        public int hCost;
        public int fCost;

        public PathNode(Cell cell) {
            this(cell, null, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public PathNode(Cell cell, PathNode parent, int gCost, int hCost) {
            this.cell = cell;
            this.parent = parent;
            this.gCost = gCost;
            this.hCost = hCost;
            this.fCost = gCost + hCost;
        }

        public void calculateFCost() {
            fCost = gCost + hCost;
        }

        @Override
        public int compareTo(PathNode other) {
            return Integer.compare(this.fCost, other.fCost);
        }
    }

    private int estimateDistance(Cell a, Cell b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    private List<Cell> getWalkableNeighbors(Cell cell, Player p) {
        List<Cell> neighbors = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();

        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dx == 0 && dy == 0) continue;

                int nx = x + dx;
                int ny = y + dy;

                if (isValidCoordinate(nx, ny)) {
                    Cell neighbor = cells[ny][nx];

                    if (neighbor.getKind() != CellKind.ROCK &&
                            neighbor.getKind() != CellKind.WATER &&
                            neighbor.getHaveAccessToThisCellPlayers().contains(p)) {

                        neighbors.add(neighbor);
                    }
                }
            }
        }

        return neighbors;
    }

    private void movePlayer(Player p, Cell fromCell, Cell toCell, List<Cell> path) {
        fromCell.setObject(null);
        toCell.setObject(p);
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