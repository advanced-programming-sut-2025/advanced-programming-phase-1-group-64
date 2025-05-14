package org.example.controller;

import org.example.config.UserRepository;
import org.example.model.Result;
import org.example.model.context.App;
import org.example.model.menus.Menu;

public class MainController {
    public Result logout() {
        App.setCurrentPlayer(null);
        App.setCurrentMenu(Menu.REGISTER_MENU);
        return new Result(true, "Logged out");
    }
}