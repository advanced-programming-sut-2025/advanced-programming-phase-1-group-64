package org.example.controller;

import org.example.config.repositories.UserRepo;
import org.example.model.Result;
import org.example.model.characters.Player;
import org.example.model.context.App;
import org.example.model.context.Game;

import java.util.ArrayList;
import java.util.List;

public class GameMenuController {
    public Result play(List<String> usernames){
        List<Player> players = new ArrayList<Player>();
        for (String username : usernames) {
            if(!UserRepo.get().exists(username))
                return new Result(false, username + " not found");
            Player player = UserRepo.get().find(username);
            if(player.isInGame())
                return new Result(false, username + " is already in a game");
            players.add(player);
        }
        Game game = new Game(App.getCurrentPlayer(), players);
    }
}