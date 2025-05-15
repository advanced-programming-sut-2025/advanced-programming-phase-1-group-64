package org.example.view;

import org.example.controller.GameMenuController;
import org.example.model.context.App;
import org.example.model.menus.Menu;

import java.util.regex.Matcher;

public class GameMenu implements AppMenu{
    private final GameMenuController controller = new GameMenuController();

    @Override public void check(String input) {
        Matcher matcher = null;
    }
    @Override public void showCurrentMenu() {
        System.out.println("game menu");
    }
    @Override public void menuEnter(String menuName) {
        if(menuName.equals("main")){
            App.setCurrentMenu(Menu.MAIN_MENU);
            System.out.println("We are now in main menu");
        }
        System.out.println("can't go here");
    }
    @Override public void menuExit() {
        App.setCurrentMenu(Menu.MAIN_MENU);
        System.out.println("We are now in main menu");
    }
}