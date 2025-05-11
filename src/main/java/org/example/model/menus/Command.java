package org.example.model.menus;

import java.util.regex.Matcher;

public interface Command {
    Matcher getMatcher(String input);
}
