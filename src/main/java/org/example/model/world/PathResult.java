package org.example.model.world;

import java.util.List;

public class PathResult {
    List<Cell> path;
    int turns;

    public PathResult(List<Cell> path, int turns) {
        this.path = path;
        this.turns = turns;
    }
}