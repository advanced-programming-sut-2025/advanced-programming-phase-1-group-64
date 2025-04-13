package StrdewValley.Models;

import StrdewValley.Models.Enums.AbilityType;
import StrdewValley.Models.Enums.Gender;
import StrdewValley.Models.Enums.SecurityQuestions;
import StrdewValley.Models.Relation.Relation;

import java.util.ArrayList;
import java.util.List;

public class User extends Character {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private final Gender gender;
    private final SecurityQuestions securityQuestion;
    private final String answerSecurityQuestion;
    private boolean isStayLoggedIn;
    private final ArrayList<Game> myGames; //should remove
    private Game currentGame;
    private int highestEarnedMoney;
    private int energyInDay;
    private boolean isFainted;
    private final ArrayList<Ability> abilities;
    private ArrayList<Relation> friendSheeps;
    private ArrayList<Relation> messages;
    private ArrayList<Relation> trades;

    public User(Gender gender, SecurityQuestions securityQuestion,
                String answerSecurityQuestion, String username,
                String password, String nickname, String email) {
        this.gender = gender;
        this.username = username;
        this.securityQuestion = securityQuestion;
        this.answerSecurityQuestion = answerSecurityQuestion;
        this.myGames = new ArrayList<>();
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.isStayLoggedIn = false;
        this.currentGame = null;
        this.highestEarnedMoney = 0;
        this.abilities = new ArrayList<>() {{
            add(new Ability(AbilityType.FARMING));
            add(new Ability(AbilityType.MINING));
            add(new Ability(AbilityType.FORAGING));
            add(new Ability(AbilityType.FISHING));
        }};
    }
}