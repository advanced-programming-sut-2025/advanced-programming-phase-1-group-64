package org.example.view;

import org.example.controller.GameController;
import org.example.model.menus.GameCommands;

import java.util.regex.Matcher;

public class VideoGame implements AppMenu{
    private final GameController controller = new GameController();

    @Override
    public void check(String input) {
        Matcher matcher = null;
        if ((matcher= GameCommands.WALK.getMatcher(input))!=null) {
            System.out.println(controller.walk(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        } else {
            System.out.println("Invalid command");
        }
    }

    @Override
    public void showCurrentMenu() {
        System.out.println("We are now in game");
    }

    @Override
    public void menuEnter(String menuName) {

    }

    @Override
    public void menuExit() {

    }
}
