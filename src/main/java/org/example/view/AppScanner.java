package org.example.view;

import org.example.model.context.App;
import org.example.model.menus.Menu;

import java.util.Scanner;

public class AppScanner {
    public static final Scanner scanner = new Scanner(System.in);

    public void run(){
        String input = "";
        do {
            input = scanner.nextLine().trim();
            App.getCurrentMenu().checkCommand(input);
        }while (App.getCurrentMenu() != (Menu.EXIT_MENU));
    }
}