package org.example.view;

import org.example.controller.MainController;
import org.example.model.context.App;
import org.example.model.menus.LoginCommands;
import org.example.model.menus.MainCommands;
import org.example.model.menus.Menu;

import java.util.regex.Matcher;

public class MainMenu implements AppMenu{
    private final MainController controller = new MainController();

    @Override public void check(String input) {
        Matcher matcher = null;
        if((matcher= MainCommands.LOGOUT.getMatcher(input))!=null){
            System.out.println(controller.logout());
        }else if((matcher= MainCommands.SHOW.getMatcher(input))!=null){
            System.out.println("profile menu\navatar menu\ngame menu");
        }else if((matcher= MainCommands.SHOW_MENU.getMatcher(input))!=null) {
            showCurrentMenu();
        }else if((matcher= MainCommands.MENU_ENTER.getMatcher(input))!=null) {
            menuEnter(matcher.group("menu"));
        }else if((matcher= MainCommands.EXIT.getMatcher(input))!=null) {
            menuExit();
        }else {
            System.out.println("Invalid command");
        }
    }
    @Override public void showCurrentMenu() {
        System.out.println("main menu");
    }
    @Override public void menuEnter(String menuName) {
        switch (menuName) {
            case "profile":
                App.setCurrentMenu(Menu.PROFILE_MENU);
                System.out.println("We are now in profile menu");
                break;
            case "game":
                App.setCurrentMenu(Menu.GAME_MENU);
                System.out.println("We are now in game menu");
                break;
            default:
                System.out.println("can't go here");
                break;
        }
    }
    @Override public void menuExit() {
        App.setCurrentMenu(Menu.REGISTER_MENU);
        System.out.println("We are now in register menu");
    }
}
