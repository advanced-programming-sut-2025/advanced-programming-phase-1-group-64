package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainCommands implements Command {
    LOGOUT("user logout"),
    MENU_ENTER("menu enter (?<menu>\\S+)"),
    EXIT("menu exit"),
    SHOW_MENU("show current menu")
    ;

    private final String pattern;

    MainCommands(String pattern) {
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