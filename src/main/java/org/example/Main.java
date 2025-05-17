package org.example;

import org.example.config.repositories.UserRepo;
import org.example.controller.GameMenuController;
import org.example.model.characters.Gender;
import org.example.model.characters.Player;
import org.example.model.characters.SecurityQuestion;
import org.example.model.context.App;
import org.example.model.context.Game;
import org.example.model.menus.Menu;
import org.example.model.world.Map;
import org.example.view.AppScanner;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = UserRepo.get().findStayLoggedIn();
        if(player != null){
           App.setCurrentPlayer(player);
           App.setCurrentMenu(Menu.MAIN_MENU);
       }
        (new AppScanner()).run();
    }
}