package org.example.view;

import org.example.controller.ProfileController;

import java.util.regex.Matcher;

public class ProfileMenu implements AppMenu {
    private final ProfileController controller = new ProfileController();

    @Override public void check(String input) {
        Matcher matcher = null;
    }
    @Override public void showCurrentMenu() {}
    @Override public void menuEnter(String menuName) {}
    @Override public void menuExit() {}
}