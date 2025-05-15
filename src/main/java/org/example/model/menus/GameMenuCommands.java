package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuCommands implements Command {
    PLAY("^game new -u (?<u1>\\S+)(?<u2> \\S+)?(?<u3> \\S+)?$"),
    MENU_ENTER("menu enter (?<menu>\\S+)"),
    EXIT("menu exit"),
    SHOW_MENU("show current menu"),
    ;

    private final String pattern;

    GameMenuCommands(String pattern) {
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