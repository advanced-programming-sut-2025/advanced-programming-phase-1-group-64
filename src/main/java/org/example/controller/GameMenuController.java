package org.example.controller;

import org.example.config.repositories.UserRepo;
import org.example.model.Result;
import org.example.model.characters.Player;
import org.example.model.characters.ability.Ability;
import org.example.model.characters.ability.AbilityType;
import org.example.model.characters.inventory.Inventory;
import org.example.model.context.App;
import org.example.model.context.Game;
import org.example.model.world.buildings.Greenhouse;

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
        for (Player player : players) {
            player.addGame();
            player.setInGame(true);
            player.setCurrentGame(game.getId());
            player.setCurrentEnergy(200);
            player.setFarming(new Ability(AbilityType.FARMING));
            player.setMining(new Ability(AbilityType.MINING));
            player.setForaging(new Ability(AbilityType.FORAGING));
            player.setFishing(new Ability(AbilityType.FISHING));
            player.setInventory(new Inventory());
            player.setGreenhouse(new Greenhouse());
        }

        return new Result(true, "game created successfully");
    }
}