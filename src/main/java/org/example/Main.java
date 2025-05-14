package org.example;

import org.example.model.characters.Gender;
import org.example.model.characters.Player;
import org.example.model.characters.SecurityQuestion;
import org.example.model.world.Cell;
import org.example.model.world.Map;
import org.example.view.AppScanner;

public class Main {
    public static void main(String[] args) {
        (new AppScanner()).run();
    }
}