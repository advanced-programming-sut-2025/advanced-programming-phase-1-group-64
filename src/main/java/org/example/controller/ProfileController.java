package org.example.controller;

import org.example.config.UserRepository;
import org.example.model.Result;
import org.example.model.characters.Player;
import org.example.model.context.App;

public class ProfileController {
    public Result changeUsername(String newUsername) {
        Player player = App.getCurrentPlayer();
        if (!Player.isValidUsername(newUsername))
            return new Result(false, "Invalid username");
        if(player.getUsername().equals(newUsername))
            return new Result(false, "Your new username is the same");
        if(UserRepository.get().exists(newUsername))
            return new Result(false, "Username already exists");

        player.setUsername(newUsername);

        return new Result(true, "username changed successfully");
    }
    public Result changeNickname(String newNickname) {
        Player player = App.getCurrentPlayer();
        if(player.getNickname().equals(newNickname))
            return new Result(false, "Your new nickname is the same");

        player.setNickname(newNickname);

        return new Result(true, "nickname changed successfully");
    }
    public Result changeEmail(String newEmail) {
        Player player = App.getCurrentPlayer();
        if (!Player.isValidEmail(newEmail))
            return new Result(false, "Invalid email");
        if(player.getEmail().equals(newEmail))
            return new Result(false, "Your new email is the same");

        player.setEmail(newEmail);

        return new Result(true, "email changed successfully");
    }
    public Result changePassword(String newPassword, String oldPassword) {
        Player player = App.getCurrentPlayer();
        if (!Player.isValidPassword(newPassword))
            return new Result(false, "\nInvalid password");
        if(!player.equalsPassword(oldPassword))
            return new Result(false, "Password does not match");
        if(player.equalsPassword(newPassword))
            return new Result(false, "Your new password is the same");

        player.setPassword(newPassword);

        return new Result(true, "password changed successfully");
    }
    public Result showUserInfo(){
        Player player = App.getCurrentPlayer();
        StringBuilder result = new StringBuilder();

        result.append("Username: ");
        result.append(player.getUsername());
        result.append("\n");
        result.append("Nickname: ");
        result.append(player.getNickname());
        result.append("\n");
        result.append("High score: ");
        result.append(player.getHighEarnedPoints());
        result.append("\n");
        result.append("Games was played: ");
        result.append(player.getGamesPlayed());

        return new Result(true, result.toString());
    }
}