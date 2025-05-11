package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginCommands implements Command {
    LOGIN("login -u (?<username>\\S+) -p (?<password>\\S+)( –stay-logged-in)?"),
    FORGET_PASSWORD("forget password -u (?<username>\\S+)"),
    ANSWER("answer -a (?<answer>\\S+)")
    ;

    private final String pattern;

    LoginCommands(String pattern) {
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