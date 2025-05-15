package org.example.model.context;

import org.example.config.repositories.GameRepo;
import org.example.model.characters.Player;
import org.example.model.world.Map;
import org.example.model.world.time.Season;
import org.example.model.world.time.SeasonType;
import org.example.model.world.time.Time;

import java.util.HashMap;
import java.util.List;

public class Game {
    private final int id;
    private final List<Player> players;
    private final Map map;
    private final Time time;
    private final Season season;
    private Player mainPlayer;
    private int turn;
    private final HashMap<Player, Integer> points;

    public Game(Player mainPlayer, List<Player> players) {
        this.id = App.gamesWasCreated();
        this.mainPlayer = mainPlayer;
        this.time = new Time();
        this.season = new Season(this.time);
        this.map = new Map();
        this.players = players;
        this.turn = 0;
        this.points = new HashMap<>();

        for (Player player : players) {
            this.points.put(player, 0);
        }

        GameRepo.save(this);
    }

    public int getId() {
        return id;
    }
}