package org.example.view;


import org.example.controller.RegisterController;
import org.example.model.context.App;
import org.example.model.menus.Menu;
import org.example.model.menus.RegisterCommands;

import java.util.regex.Matcher;

public class RegisterMenu implements AppMenu{
    private final RegisterController controller = new RegisterController();

    @Override public void check(String input) {
        Matcher matcher = null;
        if((matcher= RegisterCommands.REGISTER.getMatcher(input))!=null) {
            System.out.println(controller.register(
                    matcher.group("username"),
                    matcher.group("password"),
                    matcher.group("passwordConfirm"),
                    matcher.group("nickname"),
                    matcher.group("email"),
                    matcher.group("gender")
            ));
        } else if((matcher= RegisterCommands.EXIT.getMatcher(input))!=null) {
            menuExit();
        } else if((matcher= RegisterCommands.MENU_ENTER.getMatcher(input))!=null) {
            menuEnter(matcher.group("menu"));
        } else if((matcher= RegisterCommands.SHOW_MENU.getMatcher(input))!=null) {
            showCurrentMenu();
        } else {
            System.out.println("Invalid command");
        }
    }
    @Override public void showCurrentMenu() {
        System.out.println("register menu");
    }
    @Override public void menuEnter(String menuName) {
        if(menuName.equals("login")) {
            System.out.println("We are now in login menu");
            App.setCurrentMenu(Menu.LOGIN_MENU);
            return;
        }
        System.out.println("can't go here");
    }
    @Override public void menuExit() {
        App.setCurrentMenu(Menu.EXIT_MENU);
    }
}
