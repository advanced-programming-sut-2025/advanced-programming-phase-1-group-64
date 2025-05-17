package org.example.model.world;

import org.example.config.MineralConfig;
import org.example.config.TreeConfig;
import org.example.model.characters.Player;
import org.example.model.items.foragings.MineralSpec;
import org.example.model.items.trees.TreeSpec;
import org.example.model.world.buildings.Greenhouse;
import org.example.view.AppScanner;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Map {
    private static final int MAP_W  = 300;
    private static final int MAP_H  = 150;
    private static final int FARM_W = 80;
    private static final int FARM_H = 50;
    private static final int WALK_W = 60;
    private static final int VILL_W = 60;
    private static final int VILL_H = 50;

    private static final String RESET = "\u001B[0m";
    private static final java.util.Map<CellKind,String> COLOR = java.util.Map.ofEntries(
            java.util.Map.entry(CellKind.EMPTY,      "\u001B[38;5;232m"), // خاک تیره
            java.util.Map.entry(CellKind.GRASS,      "\u001B[32m"),       // سبز
            java.util.Map.entry(CellKind.WOOD,       "\u001B[33m"),       // زرد
            java.util.Map.entry(CellKind.ROCK,       "\u001B[37m"),       // خاکسترى
            java.util.Map.entry(CellKind.TREE,       "\u001B[32;1m"),     // سبز پررنگ
            java.util.Map.entry(CellKind.BURNED_TREE,"\u001B[30m"),
            java.util.Map.entry(CellKind.PLOW,       "\u001B[38;5;130m"), // قهوه‌اى
            java.util.Map.entry(CellKind.PLANT,      "\u001B[92m"),       // سبز روشن
            java.util.Map.entry(CellKind.LAKE,       "\u001B[34m"),       // آبى
            java.util.Map.entry(CellKind.MINE,       "\u001B[35m"),       // بنفش
            java.util.Map.entry(CellKind.GREENHOUSE, "\u001B[36m"),       // فیروز‌ه‌اى
            java.util.Map.entry(CellKind.HOME,       "\u001B[31m"),       // قرمز
            java.util.Map.entry(CellKind.WALK,       "\u001B[90m"),       // خاکسترى کم‌رنگ
            java.util.Map.entry(CellKind.VILLAGE,    "\u001B[33;1m")      // زرد پررنگ
    );

    private Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }

    private static Map createEmpty() {
        Map map = new Map();
        map.cells = new Cell[MAP_H][MAP_W];

        for (int y = 0; y < MAP_H; y++) {
            for (int x = 0; x < MAP_W; x++) {
                map.cells[y][x] = new Cell(x, new ArrayList<>(), CellKind.EMPTY, y);
            }
        }
        return map;
    }

    public static Map createMap(List<Player> players, List<Integer> types){
        return switch (players.size()){
            case 2 -> createMap(players.getFirst(), types.getFirst(), players.get(1), types.get(1));
            case 3 -> createMap(players.getFirst(), types.getFirst(), players.get(1), types.get(1), players.get(2), types.get(2));
            case 4 -> createMap(players.getFirst(), types.getFirst(), players.get(1), types.get(1), players.get(2), types.get(2), players.get(3), types.get(3));
            default -> null;
        };
    }

    private static Map createMap(Player p1, int t1, Player p2, int t2) {
        Map map = createEmpty();

        for (int y = 0; y < MAP_H; y++) {
            for (int x = 0; x < MAP_W; x++) {

                ArrayList<Player> acc = new ArrayList<>();
                CellKind kind = CellKind.EMPTY;

                if (x < FARM_W && y < FARM_H) {
                    acc.add(p1);
                } else if (x >= MAP_W - FARM_W && y < FARM_H) {
                    acc.add(p2);
                }
                else if (x >= FARM_W && x < FARM_W + WALK_W && y < FARM_H) {
                    acc.add(p1); acc.add(p2); kind = CellKind.WALK;
                }
                else if (x >= FARM_W && x < FARM_W + VILL_W &&
                        y >= FARM_H && y < FARM_H + VILL_H) {
                    acc.add(p1); acc.add(p2); kind = CellKind.VILLAGE;
                }

                map.cells[y][x] = new Cell(x, acc, kind, y);
            }
        }
        createFarmMap(0,0,t1,map.cells,p1);
        createFarmMap(MAP_W - FARM_W,0,t2,map.cells,p2);
        return map;
    }

    private static Map createMap(Player p1, int t1, Player p2, int t2,
                                Player p3, int t3) {
        Map map = createEmpty();

        for (int y = 0; y < MAP_H; y++) {
            for (int x = 0; x < MAP_W; x++) {

                ArrayList<Player> acc = new ArrayList<>();
                CellKind kind = CellKind.EMPTY;

                if (x < FARM_W && y < FARM_H) {
                    acc.add(p1);
                } else if (x >= MAP_W - FARM_W && y < FARM_H) {
                    acc.add(p2);
                } else if (x < FARM_W && y >= MAP_H - FARM_H) {
                    acc.add(p3);
                }
                else if (x >= FARM_W && x < FARM_W + WALK_W && y < FARM_H) {
                    acc.add(p1); acc.add(p2); kind = CellKind.WALK;
                }
                else if (x >= 0 && x < WALK_W && y >= FARM_H && y < FARM_H + WALK_W) {
                    acc.add(p1); acc.add(p3); kind = CellKind.WALK;
                }
                else if (x >= FARM_W && x < FARM_W + VILL_W &&
                        y >= FARM_H && y < FARM_H + VILL_H) {
                    acc.add(p1); acc.add(p2); acc.add(p3); kind = CellKind.VILLAGE;
                }

                map.cells[y][x] = new Cell(x, acc, kind, y);
            }
        }
        createFarmMap(0, 0, t1, map.cells, p1);
        createFarmMap(MAP_W - FARM_W, 0, t2, map.cells, p2);
        createFarmMap(0, MAP_H - FARM_H, t3, map.cells, p3);
        return map;
    }

    private static Map createMap(Player p1,int t1, Player p2,int t2,
                                Player p3,int t3, Player p4,int t4) {
        Map map = createEmpty();

        for (int y = 0; y < MAP_H; y++) {
            for (int x = 0; x < MAP_W; x++) {

                ArrayList<Player> acc = new ArrayList<>();
                CellKind kind   = CellKind.EMPTY;

                if (x < FARM_W && y < FARM_H) { acc.add(p1); }
                else if (x >= MAP_W - FARM_W && y < FARM_H) { acc.add(p2); }
                else if (x < FARM_W && y >= MAP_H - FARM_H) { acc.add(p3); }
                else if (x >= MAP_W - FARM_W && y >= MAP_H - FARM_H) { acc.add(p4); }
                else if (x >= FARM_W && x < FARM_W + WALK_W && y < FARM_H) {
                    acc.addAll(Arrays.asList(p1,p2)); kind = CellKind.WALK;
                }
                else if (x >= FARM_W && x < FARM_W + WALK_W &&
                        y >= MAP_H - FARM_H) {
                    acc.addAll(Arrays.asList(p3,p4)); kind = CellKind.WALK;
                }
                else if (x < WALK_W && y >= FARM_H && y < FARM_H + WALK_W) {
                    acc.addAll(Arrays.asList(p1,p3)); kind = CellKind.WALK;
                }
                else if (x >= MAP_W - WALK_W &&
                        y >= FARM_H && y < FARM_H + WALK_W) {
                    acc.addAll(Arrays.asList(p2,p4)); kind = CellKind.WALK;
                }
                else if (x >= FARM_W && x < FARM_W + VILL_W &&
                        y >= FARM_H && y < FARM_H + VILL_H) {
                    acc.addAll(Arrays.asList(p1,p2,p3,p4));
                    kind = CellKind.VILLAGE;
                }

                map.cells[y][x] = new Cell(x, acc, kind, y);
            }
        }

        createFarmMap(0, 0, t1, map.cells, p1);
        createFarmMap(MAP_W - FARM_W, 0, t2, map.cells, p2);
        createFarmMap(0, MAP_H - FARM_H, t3, map.cells, p3);
        createFarmMap(MAP_W - FARM_W, MAP_H - FARM_H, t4, map.cells, p4);
        return map;
    }

    private static void createFarmMap(int startX,int startY,int type,
                                      Cell[][] cells, Player p) {

        if (type == 1) {
            Cell.createCellType(4,4,CellKind.HOME, startY, startX, cells);
            Cell cell = cells[startY][startX];
            cell.setOccupant(p);
            p.setCell(cell);
            Cell.createCellType(6,5,CellKind.GREENHOUSE,
                    startY+1, startX + FARM_W - 15, cells);
            Cell.createCellType(1,5,CellKind.LAKE,
                    startY, startX + FARM_W - 15, cells);
            Cell.createCellType(5,4,CellKind.MINE,
                    startY + 4, startX, cells);
            Cell.createCellType(3,5,CellKind.LAKE,
                    startY + 7, startX + FARM_W - 15, cells);
        }
        else {
            Cell.createCellType(3,4,CellKind.LAKE, startY, startX, cells);
            Cell.createCellType(3,4,CellKind.LAKE, startY + 7, startX, cells);
            Cell.createCellType(4,5,CellKind.MINE,  startY, startX + FARM_W - 15, cells);
            Cell.createCellType(4,4,CellKind.HOME,  startY + 3, startX, cells);
            Cell cell = cells[startY + 3][startX];
            cell.setOccupant(p);
            p.setCell(cell);
            Cell.createCellType(1,5,CellKind.LAKE,
                    startY + 4, startX + FARM_W - 15, cells);
            Cell.createCellType(6,5,CellKind.GREENHOUSE,
                    startY + 5, startX + FARM_W - 15, cells);
        }

        fillCenterArea(cells, startX, startY,
                FARM_W, FARM_H);
    }

    private static void fillCenterArea(Cell[][] cells,int sx,int sy,int w,int h) {
        List<TreeSpec> allTrees = new ArrayList<>(TreeConfig.all());
        List<MineralSpec> allMinerals = MineralConfig.all();

        for (TreeSpec tree : allTrees) {
            boolean placed = false;
            while (!placed) {
                int x = sx + ThreadLocalRandom.current().nextInt(w);
                int y = sy + ThreadLocalRandom.current().nextInt(h);
                if (cells[y][x].getKind() == CellKind.EMPTY){
                    cells[y][x].setKind(CellKind.TREE);
                    cells[y][x].setObject(tree);
                    placed = true;
                }
            }
        }

        for (int y = sy; y < sy + h; y++) {
            for (int x = sx; x < sx + w; x++) {

                Cell cell = cells[y][x];

                if (cell.getKind() == CellKind.EMPTY) {
                    if (Math.random() < 0.85){
                        double r = Math.random();
                        if (r < 0.5) {
                            TreeSpec tree = allTrees.get(
                                    ThreadLocalRandom.current().nextInt(allTrees.size()));
                            cell.setKind(CellKind.TREE);
                            cell.setObject(tree);
                        } else if (r < 0.75){
                            cell.setKind(CellKind.GRASS);
                        } else if (r < 0.875){
                            cell.setKind(CellKind.WOOD);
                        } else {
                            cell.setKind(CellKind.ROCK);
                        }
                    }
                }
                else if (cell.getKind() == CellKind.MINE) {
                    if (Math.random() < 0.6) {
                        MineralSpec mineral = allMinerals.get(
                                ThreadLocalRandom.current().nextInt(allMinerals.size()));
                        cell.setObject(mineral);
                    }
                }
            }
        }
    }

    private static String colorOf(Cell cell) {
        if (cell.getObject() instanceof Player)       return "\u001B[96m";
        if (cell.getKind() == CellKind.MINE &&
                cell.getObject() instanceof MineralSpec)  return "\u001B[95m";
        return COLOR.getOrDefault(cell.getKind(), "");
    }

    public String printMapColored(Player p, int radius){
        Cell pos = p.getCell();
        int cx = pos.getX();
        int cy = pos.getY();

        int startX = Math.max(0, cx - radius);
        int startY = Math.max(0, cy - radius);
        int size = radius*2 + 1;

        return printMapColored(startX, startY, size);
    }
    private String printMapColored(int x0, int y0, int size){
        int startX = Math.max(0, x0);
        int startY = Math.max(0, y0);
        int endX   = Math.min(MAP_W, x0 + size);
        int endY   = Math.min(MAP_H, y0 + size);

        StringBuilder sb = new StringBuilder();

        sb.append('+');
        for (int i = startX; i < endX; i++) sb.append("---");
        sb.append("-+\n");

        for (int y = startY; y < endY; y++) {
            sb.append("| ");
            for (int x = startX; x < endX; x++) {
                Cell c = cells[y][x];
                char ch = (c.getObject()!=null) ?
                        c.getObject().toString().charAt(0) :
                        c.getKind().getCellChar();
                ch = c.getOccupant()!=null ? c.getOccupant().toString().charAt(0) : ch;
                sb.append(colorOf(c)).append(ch).append(RESET).append("  ");
            }
            sb.append("|\n");
        }

        sb.append('+');
        for (int i = startX; i < endX; i++) sb.append("---");
        sb.append("-+");
        return sb.toString();
    }

    public String helpReadingMap(){
        StringBuilder sb = new StringBuilder("Map Legend (colored):\n");
        for(CellKind k : CellKind.values()){
            sb.append(colorOf(new Cell(0,new ArrayList<>(),k,0)))
                    .append(k.getCellChar()).append(RESET)
                    .append(" : ").append(k.getCellName()).append('\n');
        }
        sb.append("\u001B[96m@\u001B[0m : Player\n")
                .append("\u001B[95m*\u001B[0m : Mineral on mine tile\n");
        return sb.toString();
    }

    public void walk(Player p, int tx, int ty) {
        Cell from = p.getCell();

        if (!isValidCoordinate(tx, ty)) {
            System.out.println("Error: Target coordinates are out of bounds!");
            return;
        }

        Cell targetCell = cells[tx][ty];

        if (!targetCell.getHaveAccessToThisCellPlayers().contains(p)) {
            System.out.println("Error: You don't have access to this player's farm!");
            return;
        }

        PathResult pr = findShortestPath(from, targetCell, p);
        if (pr == null) {
            System.out.println("Error: No valid path to target!");
            return;
        }

        int distance = pr.path.size() - 1;
        int energyNeeded = (int) Math.ceil(distance / 20.0);

        System.out.println("Energy needed: " + energyNeeded);
        System.out.println("Confirm movement? (yes/no)");

        boolean confirmed = false;
        confirmed = AppScanner.scanner.nextLine() == "yes";

        if (!confirmed) return;
        if (p.getCurrentEnergy() < energyNeeded) {
            p.setFainted(true);
            System.out.println("You are fainted");
            return;
        }

        from.setOccupant(null);
        targetCell.setOccupant(p);
        p.setCell(targetCell);
        p.costCurrentEnergy(energyNeeded);

        System.out.println("New energy: " + p.getCurrentEnergy());
    }

    private static int countTurns(List<Cell> path){
        if (path.size() < 3) return 0;
        int turns = 0;
        int prevDx = path.get(1).getX() - path.get(0).getX();
        int prevDy = path.get(1).getY() - path.get(0).getY();

        for (int i=2; i<path.size(); i++){
            int dx = path.get(i).getX() - path.get(i-1).getX();
            int dy = path.get(i).getY() - path.get(i-1).getY();
            if (dx != prevDx || dy != prevDy) turns++;
            prevDx = dx; prevDy = dy;
        }

        return turns;
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < MAP_W && y >= 0 && y < MAP_H;
    }

    private static int energyForPath(List<Cell> path) {
        int dist = path.size() - 1;
        int turns = countTurns(path);
        return (int) Math.ceil((dist + 10*turns) / 20.0);
    }

    public void walkScored(Player p, int tx, int ty) {
        Cell from = p.getCell();

        if (!isValidCoordinate(tx, ty)) {
            System.out.println("Error: Target coordinates are out of bounds!");
            return;
        }
        Cell goal = cells[ty][tx];
        if(!goal.getHaveAccessToThisCellPlayers().contains(p)) {
            System.out.println("Error: You don't have access to this player's farm!");
            return;
        }

        PathResult pr = findShortestPath(from, goal, p);
        if (pr == null) {
            System.out.println("Error: No valid path to target!");
            return;
        }

        int energyNeeded = energyForPath(pr.path);
        System.out.printf("distance: %d | turns: %d | energy: %d\n", pr.path.size()-1 , countTurns(pr.path), energyNeeded);

        System.out.println("Confirm movement? (yes/no)");

        boolean confirmed = false;
        String choice = AppScanner.scanner.nextLine();
        confirmed = (choice.equals("yes"));

        if (!confirmed) {System.out.println("We don't move"); return;}
        int energy = p.getTurnEnergy();
        Cell prev = from;
        for (int i=1; i<pr.path.size(); i++){
            Cell next = pr.path.get(i);

            int stepCost = 1;
            int dx1 = next.getX() - prev.getX();
            int dy1 = next.getY() - prev.getY();
            int dx0 = prev.getX() - (i>1? pr.path.get(i-1).getX():prev.getX());
            int dy0 = prev.getY() - (i>1? pr.path.get(i-1).getY():prev.getY());
            if (i>1 && (dx1!=dx0 || dy1!=dy0)) stepCost += 10;

            int costUnit = (stepCost+19) / 20;

            if(energy < costUnit){
                p.setFainted(true);
                p.setCell(prev);
                prev.setOccupant(p);
                System.out.println("Fainted in: " + prev.getX() + "," + prev.getY());
                return;
            }

            energy -= costUnit;
            p.setTurnEnergy(energy);
            prev.setOccupant(null);
            next.setOccupant(p);
            prev = next;
        }

        p.setTurnEnergy(energy);
        p.setCell(goal);
        System.out.println("You are now in targetCell");
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
                int newCost = current.gCost + 1;

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

    private boolean isBlocked(Player p,Cell c) {
        return switch (c.getKind()){
            case ROCK, LAKE,
                 TREE, BURNED_TREE, WOOD -> true;

            case MINE -> c.getObject() instanceof MineralSpec;
            case GREENHOUSE -> !(p.getGreenhouse().isBuilt());
            default -> false;
        };
    }

    private List<Cell> getWalkableNeighbors(Cell cell, Player p) {
        List<Cell> neighbors = new ArrayList<>();
        int x = cell.getX(); int y = cell.getY();

        for (int dy = -1; dy <=1; dy++)
            for (int dx = -1; dx <=1; dx++){
                if (dx == 0 && dy == 0) continue;

                int nx = x + dx, ny = y + dy;
                if (!isValidCoordinate(nx, ny)) continue;

                Cell n = cells[ny][nx];
                if(!isBlocked(p, n) && n.getHaveAccessToThisCellPlayers().contains(p))
                    neighbors.add(n);
            }
        return neighbors;
    }
}