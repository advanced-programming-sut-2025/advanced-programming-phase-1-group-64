package StrdewValley.Models;

import StrdewValley.Models.Enums.Gender;
import StrdewValley.Models.Enums.SecurityQuestions;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private final Gender gender;
    private final SecurityQuestions securityQuestion;
    private final String answerSecurityQuestion;
    private final ArrayList<Game> games;
    private Game currentGame;
    private int playedGames;
    private int highestEarnedMoney;

    public User(Gender gender, SecurityQuestions securityQuestion, String answerSecurityQuestion) {
        this.gender = gender;
        this.securityQuestion = securityQuestion;
        this.answerSecurityQuestion = answerSecurityQuestion;
        this.games = new ArrayList<>();
    }
}
