package org.example.view;

import org.example.controller.MainController;

import java.util.regex.Matcher;

public class MainMenu implements AppMenu{
    private final MainController controller = new MainController();

    @Override public void check(String input) {
        Matcher matcher = null;
    }
    @Override public void showCurrentMenu() {}
    @Override public void menuEnter(String menuName) {}
    @Override public void menuExit() {}
}
