package org.example;

import org.example.config.repositories.UserRepo;
import org.example.model.characters.Player;
import org.example.model.context.App;
import org.example.model.menus.Menu;
import org.example.view.AppScanner;

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