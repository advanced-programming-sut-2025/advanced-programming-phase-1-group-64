package org.example.model.characters;

import org.example.model.characters.ability.Ability;
import org.example.model.characters.inventory.Inventory;
import org.example.model.world.Cell;

public class Player extends Character{
    private String username;
    private String password;
    private String email;
    private Gender gender;

    private final SecurityQuestion question;
    private final String answer;

    private boolean stayLoggedIn;

    public Player(String name, String username, String password,
                  String email, Gender gender, SecurityQuestion question,
                  String answer, boolean stayLoggedIn) {
        super(name);
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.question = question;
        this.answer = answer;
        this.stayLoggedIn = stayLoggedIn;
    }

    private int highEarnedPoints;
    private int gamesPlayed;

    public void addGame(){
        this.gamesPlayed++;
    }

    private boolean isInGame;

    private int currentEnergy;
    private int maxEnergy = 200;
    private boolean fainted;

    private Cell cell;

    private Ability farming,mining,foraging, fishing;
    private Inventory inventory;
}