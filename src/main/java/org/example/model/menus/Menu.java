package org.example.model.menus;

import org.example.view.*;

public enum Menu {
    REGISTER_MENU(new RegisterMenu()),
    LOGIN_MENU(new LoginMenu()),
    MAIN_MENU(new MainMenu()),
    GAME_MENU(new GameMenu()),
    GAME(new VideoGame()),
    PROFILE_MENU(new ProfileMenu()),
    AVATAR_MENU(new AvatarMenu()),
    EXIT_MENU(new ExitMenu());
    ;


    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void checkCommand(String input) {
        this.menu.check(input);
    }
}