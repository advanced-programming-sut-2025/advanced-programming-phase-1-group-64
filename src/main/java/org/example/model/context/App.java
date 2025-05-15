package org.example.model.context;

import org.example.config.repositories.StatRepo;
import org.example.model.characters.Player;
import org.example.model.menus.Menu;

public class App {
    private static Menu currentMenu = Menu.REGISTER_MENU;
    private static Player currentPlayer = null;
    private static int gamesWasCreated = 0;

    static {
        StatRepo.load();
    }

    public static int getGamesWasCreated() {return gamesWasCreated;}
    public static void setGamesWasCreated(int n) {gamesWasCreated = n;}
    public static int gamesWasCreated() {gamesWasCreated++; StatRepo.save(); return gamesWasCreated;}
    public static Menu getCurrentMenu() {return currentMenu;}
    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
    public static void setCurrentPlayer(Player currentPlayer) {
        App.currentPlayer = currentPlayer;
    }
}