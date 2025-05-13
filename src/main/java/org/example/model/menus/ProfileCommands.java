package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileCommands implements Command{
    CHANGE_USERNAME("change username -u (?<username>\\S+"),
    CHANGE_NICKNAME("change nickname -n (?<nickname>\\S.*)"),
    CHANGE_EMAIL("change email -e (?<email>\\S+)"),
    CHANGE_PASSWORD("change password -p (?<newPassword>\\S+) -o (?<oldPassword>\\S+)"),
    USER_INFO("user info"),
    MENU_ENTER("menu enter (<?menu>\\S+)"),
    EXIT("menu exit"),
    SHOW_MENU("show current menu")
    ;

    private final String pattern;

    ProfileCommands(String pattern) {
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
