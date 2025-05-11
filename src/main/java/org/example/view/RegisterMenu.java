package org.example.view;


import org.example.controller.RegisterController;

import java.util.regex.Matcher;

public class RegisterMenu implements AppMenu{
    private final RegisterController controller = new RegisterController();

    @Override public void check(String input) {
        Matcher matcher = null;
    }
    @Override public void showCurrentMenu() {}
    @Override public void menuEnter(String menuName) {}
    @Override public void menuExit() {}
}
