package org.example.controller;

import org.example.config.repositories.UserRepo;
import org.example.model.Result;
import org.example.model.characters.Gender;
import org.example.model.characters.Player;
import org.example.model.characters.SecurityQuestion;
import org.example.model.context.App;
import org.example.model.menus.Menu;
import org.example.model.menus.RegisterCommands;
import org.example.view.AppScanner;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegisterController {
    private String changeUsername(String username) {
        int counter = 0;

        for (Player player : UserRepo.get().all()) {
            if (player.getUsername().contains(username))
                counter++;
        }

        String adder = "-" + counter;
        return username+adder;
    }
    private String randomPassword() {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = lower.toUpperCase();
        String digits = "0123456789";
        String special = "?><,/\\|][}{+=)(*&^%$#!";
        String all = lower + upper + digits + special;

        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder();

        sb.append(lower.charAt(random.nextInt(lower.length())));
        sb.append(upper.charAt(random.nextInt(upper.length())));
        sb.append(digits.charAt(random.nextInt(digits.length())));
        sb.append(special.charAt(random.nextInt(special.length())));

        for(int i=4; i<10; i++)
            sb.append(all.charAt(random.nextInt(all.length())));

        char[] pwd = sb.toString().toCharArray();
        for (int i = pwd.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char tmp = pwd[i];
            pwd[i] = pwd[j];
            pwd[j] = tmp;
        }

        return new String(pwd);
    }

    public Result register(String username, String password, String passwordConfirm,
                           String nickname, String email, String gender) {

        Scanner scanner = AppScanner.scanner;

        if (UserRepo.get().exists(username)) {
            username = changeUsername(username);
            System.out.println("This username is already taken, your new username is: " + username);
            String choice = "";
            System.out.println("Enter new username or continue: ");
            choice = scanner.nextLine();
            if(!choice.equals("continue")){
                username = choice;
            }
        }
        if (!Player.isValidUsername(username))
            return new Result(false, "Invalid username");
        if (!Player.isValidEmail(email))
            return new Result(false, "Invalid email");
        if (password.equalsIgnoreCase("tasadofi") && password.equalsIgnoreCase(passwordConfirm)){
            String choice = "";
            while (!choice.equalsIgnoreCase("ok")) {
                password = randomPassword();
                passwordConfirm = password;
                System.out.println("Your password is: " + password);
                System.out.println("It's ok or change it or exit?");
                choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("exit")) return new Result(false, "Back to register menu");
            }
        }
        if (!Player.isValidPassword(password))
            return new Result(false, "\nInvalid password");
        while (!password.equals(passwordConfirm)){
            System.out.println("Enter your password again or exit :");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit")) return new Result(false, "Back to register menu");
            passwordConfirm = choice;
        }
        Gender gen = Gender.getGender(gender);

        System.out.println("Select one question and answer it:");
        System.out.println("1- "+ SecurityQuestion.Q1.getQuestion()+
                "\n2- "+ SecurityQuestion.Q2.getQuestion()+
                "\n3- "+ SecurityQuestion.Q3.getQuestion()+
                "\n4- "+ SecurityQuestion.Q4.getQuestion()+
                "\n5- "+ SecurityQuestion.Q5.getQuestion());

        String choiceQuestion = scanner.nextLine();
        Matcher matcher = null;

        if((matcher= RegisterCommands.QUESTION.getMatcher(choiceQuestion))!=null) {
            String questionNumber = matcher.group("questionNumber");
            String answer = matcher.group("answer");
            String answerConfirm = matcher.group("answerConfirm");
            while (!answer.equals(answerConfirm)) {
                System.out.println("Enter your answer again or exit :");
                answerConfirm = scanner.nextLine();
                if (answerConfirm.equalsIgnoreCase("exit")) return new Result(false, "Back to register menu");
            }

            SecurityQuestion question = SecurityQuestion.getQuestion(questionNumber);
            password = Player.sha256(password);
            Player player = new Player(nickname, username, password, email, gen, question, answer);
            UserRepo.get().add(player);
            App.setCurrentMenu(Menu.LOGIN_MENU);
            return new Result(true, "Register successful");
        }
        return new Result(false, "Invalid command");
    }
}