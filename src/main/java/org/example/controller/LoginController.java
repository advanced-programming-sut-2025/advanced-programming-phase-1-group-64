package org.example.controller;

import org.example.config.repositories.UserRepo;
import org.example.model.Result;
import org.example.model.characters.Player;
import org.example.model.context.App;
import org.example.model.menus.LoginCommands;
import org.example.model.menus.Menu;
import org.example.view.AppScanner;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginController {
    public Result login(String username, String password, boolean stayLoggedIn){
        if(!UserRepo.get().exists(username))
            return new Result(false, "Username not found");
        Player player = UserRepo.get().find(username);
        if(!player.equalsPassword(password))
            return new Result(false, "Wrong password");
        player.setStayLoggedIn(stayLoggedIn);
        App.setCurrentPlayer(player);
        App.setCurrentMenu(Menu.MAIN_MENU);
        return new Result(true, "Login successful");
    }

    public Result forgetPassword(String username){
        if(!UserRepo.get().exists(username))
            return new Result(false, "Username not found");
        Player player = UserRepo.get().find(username);
        System.out.println("Answer your security question please: " + player.getQuestion().getQuestion());

        Scanner scanner = AppScanner.scanner;
        String answer = scanner.nextLine();
        Matcher matcher = null;
        if((matcher= LoginCommands.ANSWER.getMatcher(answer))!=null) {
            answer = matcher.group("answer");
            if (!answer.equals(player.getAnswer()))
                return new Result(false, "Wrong answer");
            System.out.println("Please enter your new-password:");
            String newPassword = scanner.nextLine();

            if (!Player.isValidPassword(newPassword))
                return new Result(false, "\nInvalid password");

            player.setPassword(newPassword);
            return new Result(true, "Password changed successfully");
        }
        return new Result(false, "Invalid command");
    }
}