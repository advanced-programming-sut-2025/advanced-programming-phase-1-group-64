package org.example.view;

import org.example.controller.LoginController;

import java.util.regex.Matcher;

public class LoginMenu implements AppMenu{
    private final LoginController controller = new LoginController();

    @Override public void check(String input) {
        Matcher matcher = null;
    }
    @Override public void showCurrentMenu() {}
    @Override public void menuEnter(String menuName) {}
    @Override public void menuExit() {}
}