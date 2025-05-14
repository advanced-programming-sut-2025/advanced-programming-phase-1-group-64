package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameCommands implements Command {
    PLAY("game new -u (?<username_1>\\S+)? (?<username_2>\\S+)? (?<username_3>\\S+)?"),
    MENU_ENTER("menu enter (<?menu>\\S+)"),
    EXIT("menu exit"),
    SHOW_MENU("show current menu"),
    ;

    private final String pattern;

    GameCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(pattern).matcher(input);
        if(matcher.matches())
            return matcher;
        return null;
    }
}