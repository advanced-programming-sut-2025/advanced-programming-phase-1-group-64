package org.example.view;

import org.example.controller.GameController;

public class VideoGame implements AppMenu{
    private final GameController controller = new GameController();

    @Override
    public void check(String input) {

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
