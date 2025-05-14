package org.example.view;

import org.example.controller.LoginController;
import org.example.model.context.App;
import org.example.model.menus.LoginCommands;
import org.example.model.menus.Menu;

import java.util.regex.Matcher;

public class LoginMenu implements AppMenu{
    private final LoginController controller = new LoginController();

    @Override public void check(String input) {
        Matcher matcher = null;
        if((matcher= LoginCommands.LOGIN.getMatcher(input))!=null) {
            boolean isStay = false;
            if(matcher.group("stay")!=null)
                isStay = true;
            System.out.println(controller.login(
                    matcher.group("username"),
                    matcher.group("password"),
                    isStay
            ));
        }else if((matcher= LoginCommands.FORGET_PASSWORD.getMatcher(input))!=null) {
            System.out.println(controller.forgetPassword(
                    matcher.group("username")
            ));
        }else if((matcher= LoginCommands.SHOW_MENU.getMatcher(input))!=null) {
            showCurrentMenu();
        }else if((matcher= LoginCommands.MENU_ENTER.getMatcher(input))!=null) {
            menuEnter(matcher.group("menu"));
        }else if((matcher= LoginCommands.EXIT.getMatcher(input))!=null) {
            menuExit();
        }else {
            System.out.println("Invalid command");
        }
    }
    @Override public void showCurrentMenu() {
        System.out.println("login menu");
    }
    @Override public void menuEnter(String menuName) {
        if(menuName.equals("register")){
            System.out.println("We are now in register menu");
            App.setCurrentMenu(Menu.REGISTER_MENU);
            return;
        }
        System.out.println("can't go here");
    }
    @Override public void menuExit() {
        App.setCurrentMenu(Menu.EXIT_MENU);
    }
}