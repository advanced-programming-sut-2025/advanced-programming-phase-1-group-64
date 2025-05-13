package org.example.model.context;

import org.example.model.characters.Player;
import org.example.model.menus.Menu;

public class App {
    private static Menu currentMenu = Menu.REGISTER_MENU;
    private static Player currentPlayer = null;

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
