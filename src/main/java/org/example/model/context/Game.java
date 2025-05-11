package org.example.model.context;

import org.example.model.characters.Player;
import org.example.model.world.Map;
import org.example.model.world.time.Time;

import java.util.HashMap;
import java.util.List;

public class Game {
    private final List<Player> players;
    private final Map map;
    private final Time time;
    private Player mainPlayer;
    private int turn;
    private final HashMap<Player, Integer> points;

    public Game(Player mainPlayer, Time time, List<Player> players) {
        this.mainPlayer = mainPlayer;
        this.time = time;
        this.map = new Map();
        this.players = players;
        this.turn = 0;
        this.points = new HashMap<>();
    }
}