package org.example;

import org.example.model.characters.Gender;
import org.example.model.characters.Player;
import org.example.model.characters.SecurityQuestion;
import org.example.model.world.Cell;
import org.example.model.world.Map;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player("taha", "ali", "000", "t@t.t", Gender.MALE, SecurityQuestion.Q1, "Yes");
        Player p2 = new Player("reza", "ali", "000", "t@t.t", Gender.MALE, SecurityQuestion.Q1, "Yes");
        Map map = Map.createMap(p1, 2, p2, 2);

//        for (int y = 0; y < 30; y++) {
//            for (int x = 0; x < 50; x++) {
//                System.out.printf("%12s ", map.getCells()[y][x].getKind());
//            }
//            System.out.printf("\n");
//        }

//        System.out.print(map.helpReadingMap());
        System.out.print(map.printMap(0, 0, 30));
//
//        for (int i = 0; i < 50; i++) {
//            System.out.println(Math.random());
//        }
    }
}