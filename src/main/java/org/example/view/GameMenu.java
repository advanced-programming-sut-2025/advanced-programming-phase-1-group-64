package org.example.view;

import org.example.controller.GameController;
import org.example.model.context.App;
import org.example.model.menus.GameCommands;
import org.example.model.menus.Menu;

import java.util.regex.Matcher;

public class GameMenu implements AppMenu{
    private final GameController controller = new GameController();

    @Override public void check(String input) {
        Matcher matcher = null;
        if((matcher= GameCommands.))
    }
    @Override public void showCurrentMenu() {
        System.out.println("game menu");
    }
    @Override public void menuEnter(String menuName) {
        switch (menuName){
            default :
                System.out.println("can't go here");
                break;
        }
    }
    @Override public void menuExit() {
    }
}
