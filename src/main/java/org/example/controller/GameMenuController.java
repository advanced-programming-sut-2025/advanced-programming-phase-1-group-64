package org.example.controller;

import org.example.config.repositories.UserRepo;
import org.example.model.Result;
import org.example.model.characters.Player;
import org.example.model.characters.ability.Ability;
import org.example.model.characters.ability.AbilityType;
import org.example.model.characters.inventory.Inventory;
import org.example.model.context.App;
import org.example.model.context.Game;
import org.example.model.menus.GameMenuCommands;
import org.example.model.menus.Menu;
import org.example.model.world.Map;
import org.example.model.world.buildings.Greenhouse;
import org.example.model.world.buildings.Home;
import org.example.view.AppScanner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;

public class GameMenuController {
    public Result play(List<String> usernames){
        List<Player> players = new ArrayList<>();
        for (String username : usernames) {
            if(!UserRepo.get().exists(username))
                return new Result(false, username + " not found");
            Player player = UserRepo.get().find(username);
            if(player.isInGame())
                return new Result(false, username + " is already in a game");
            players.add(player);
        }
        Game game = new Game(App.getCurrentPlayer(), players);

        List<Integer> typeOfMap = new ArrayList<>();

        for (Player player : players) {
            System.out.println("Choosing map for players");
            System.out.println("1-Map with larger mining\n2-Map with two lake");

            player.addGame();
            player.setInGame(true);
            player.setCurrentGame(game.getId());
            player.setCurrentEnergy(200);
            player.setTurnEnergy(50);
            player.setFarming(new Ability(AbilityType.FARMING));
            player.setMining(new Ability(AbilityType.MINING));
            player.setForaging(new Ability(AbilityType.FORAGING));
            player.setFishing(new Ability(AbilityType.FISHING));
            player.setInventory(new Inventory());
            player.setGreenhouse(new Greenhouse());
            player.setHome(new Home());
            player.setKnownCraftingRecipes(new HashSet<>());
            player.getKnownCraftingRecipes().add("Furnace");
            player.getKnownCraftingRecipes().add("Scarecrow");

            while (true) {
                Matcher matcher = null;
                String choice = AppScanner.scanner.nextLine();
                if ((matcher = GameMenuCommands.GAME_MAP.getMatcher(choice)) != null) {
                    typeOfMap.add(Integer.parseInt(matcher.group("map")));
                    break;
                } else {
                    System.out.println("Input type must be like: game map <number>");
                    continue;
                }
            }
        }

        game.setMap(Map.createMap(players, typeOfMap));
        App.setCurrentGame(game);
        App.setCurrentMenu(Menu.GAME);
        return new Result(true, "game started");
    }
//    public Result loadGame(){
//
//    }
}