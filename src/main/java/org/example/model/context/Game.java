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
    private Map map;
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
    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {this.map = map;}
    public List<Player> getPlayers() {
        return players;
    }
    public int getTurn() {
        return turn;
    }
    public void nextTurn() {
        getCurrentPlayer().costCurrentEnergy((-1)*getCurrentPlayer().getTurnEnergy());
        turn++;
        turn %= players.size();
        if (turn == 0){
            time.nextHours(this);
            for (Player player : players) {
                if (player.getCurrentEnergy() > 1_000)
                    continue;
                int energy = Math.min(player.getCurrentEnergy(), 50);
                player.costCurrentEnergy(energy);
                player.setTurnEnergy(energy);
            }
            // تابع های 1 ساعت 1 بار
            //TODO
        }
    }
    public Player getCurrentPlayer() {
        return players.get(turn);
    }
    public Time getTime() {
        return time;
    }
    public Season getSeason() {return season;}
    public HashMap<Player, Integer> getPoints() {
        return points;
    }
}