package org.example.view;

import org.example.controller.AvatarController;
import org.example.model.context.App;
import org.example.model.menus.AvatarCommands;
import org.example.model.menus.Menu;
import org.example.model.menus.ProfileCommands;

import java.util.regex.Matcher;

public class AvatarMenu implements AppMenu {
    private final AvatarController controller = new AvatarController();

    @Override public void check(String input) {
        Matcher matcher = null;
        if((matcher= AvatarCommands.SHOW_MENU.getMatcher(input))!=null) {
            showCurrentMenu();
        }else if((matcher= AvatarCommands.MENU_ENTER.getMatcher(input))!=null) {
            menuEnter(matcher.group("menu"));
        }else if((matcher= AvatarCommands.EXIT.getMatcher(input))!=null) {
            menuExit();
        }else {
            System.out.println("Invalid command");
        }
    }
    @Override public void showCurrentMenu() {
        System.out.println("avatar menu");
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