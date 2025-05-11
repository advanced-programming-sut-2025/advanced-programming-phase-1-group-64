package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum AvatarCommands implements Command {
    ;

    private final String pattern;

    AvatarCommands(String pattern) {
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