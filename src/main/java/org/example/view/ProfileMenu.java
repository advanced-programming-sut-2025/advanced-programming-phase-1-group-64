package org.example.view;

import org.example.controller.ProfileController;
import org.example.model.context.App;
import org.example.model.menus.MainCommands;
import org.example.model.menus.Menu;
import org.example.model.menus.ProfileCommands;

import java.util.regex.Matcher;

public class ProfileMenu implements AppMenu {
    private final ProfileController controller = new ProfileController();

    @Override public void check(String input) {
        Matcher matcher = null;
        if((matcher= ProfileCommands.CHANGE_USERNAME.getMatcher(input))!=null){
            System.out.println(controller.changeUsername(matcher.group("username")));
        }else if((matcher= ProfileCommands.CHANGE_NICKNAME.getMatcher(input))!=null){
            System.out.println(controller.changeNickname(matcher.group("nickname")));
        }else if((matcher= ProfileCommands.CHANGE_EMAIL.getMatcher(input))!=null){
            System.out.println(controller.changeEmail(matcher.group("email")));
        }else if((matcher= ProfileCommands.CHANGE_PASSWORD.getMatcher(input))!=null){
            System.out.println(controller.changePassword(matcher.group("newPassword"), matcher.group("oldPassword")));
        }else if((matcher= ProfileCommands.USER_INFO.getMatcher(input))!=null){
            System.out.println(controller.showUserInfo());
        }else if((matcher= ProfileCommands.SHOW_MENU.getMatcher(input))!=null) {
            showCurrentMenu();
        }else if((matcher= ProfileCommands.MENU_ENTER.getMatcher(input))!=null) {
            menuEnter(matcher.group("menu"));
        }else if((matcher= ProfileCommands.EXIT.getMatcher(input))!=null) {
            menuExit();
        }else {
            System.out.println("Invalid command");
        }
    }
    @Override public void showCurrentMenu() {
        System.out.println("profile menu");
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