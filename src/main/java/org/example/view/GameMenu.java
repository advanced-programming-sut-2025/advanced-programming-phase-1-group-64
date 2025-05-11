package org.example.view;

import org.example.controller.GameController;

import java.util.regex.Matcher;

public class GameMenu implements AppMenu{
    private final GameController controller = new GameController();

    @Override public void check(String input) {
        Matcher matcher = null;
    }
    @Override public void showCurrentMenu() {}
    @Override public void menuEnter(String menuName) {}
    @Override public void menuExit() {}
}
