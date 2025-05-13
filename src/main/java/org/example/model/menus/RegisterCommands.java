package org.example.model.menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterCommands implements Command{
    REGISTER("register -u (?<username>\\S+) -p (?<password>\\S+) (?<password_confirm>\\S+) -n (?<nickname>\\S.*) -e (?<email>\\S+) -g (?<gender>\\S+)"),
    QUESTION("pick question -q (?<question_number>\\d) -a (?<answer>\\S.*) -c (?<answer_confirm>\\S.*)"),
    MENU_ENTER("menu enter (<?menu>\\S+)"),
    EXIT("menu exit"),
    SHOW_MENU("show current menu")
    ;

    private final String pattern;

    RegisterCommands(String pattern) {
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