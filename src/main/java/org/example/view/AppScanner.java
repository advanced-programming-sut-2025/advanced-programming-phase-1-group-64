package org.example.view;

import org.example.model.context.App;
import org.example.model.menus.Menu;

import java.util.Scanner;

public class AppScanner {
    public static final Scanner scanner = new Scanner(System.in);

    public void run(){
        String input = "";
        do {

        }while (!App.getCurrentMenu().equals(Menu.EXIT_MENU));
    }
}
