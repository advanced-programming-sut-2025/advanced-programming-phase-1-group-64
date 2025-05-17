package org.example.view;

import org.example.controller.GameMenuController;
import org.example.model.context.App;
import org.example.model.menus.GameMenuCommands;
import org.example.model.menus.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu{
    private final GameMenuController controller = new GameMenuController();

    @Override public void check(String input) {
        Matcher matcher = null;
        if((matcher= GameMenuCommands.PLAY.getMatcher(input))!=null){
            List<String> usernames = new ArrayList<>();
            usernames.add(App.getCurrentPlayer().getUsername());
            for (String g : List.of("u1", "u2", "u3")) {
                String val = matcher.group(g);
                if (val != null) usernames.add(val);
            }
            System.out.println(controller.play(usernames));
        }else if((matcher= GameMenuCommands.SHOW_MENU.getMatcher(input))!=null){
            showCurrentMenu();
        }else if((matcher= GameMenuCommands.MENU_ENTER.getMatcher(input))!=null){
            menuEnter(matcher.group("menu"));
        }else if((matcher= GameMenuCommands.EXIT.getMatcher(input))!=null){
            menuExit();
        }else {
            System.out.println("Invalid command");
        }
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