package org.example.view;

import org.example.controller.AvatarController;

import java.util.regex.Matcher;

public class AvatarMenu implements AppMenu {
    private final AvatarController controller = new AvatarController();

    @Override public void check(String input) {
        Matcher matcher = null;
    }
    @Override public void showCurrentMenu() {}
    @Override public void menuEnter(String menuName) {}
    @Override public void menuExit() {}
}