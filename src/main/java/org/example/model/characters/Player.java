package org.example.model.characters;

import org.example.model.characters.ability.Ability;
import org.example.model.characters.inventory.Inventory;
import org.example.model.world.Cell;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Player extends Character{
    private String username;
    private String password;
    private String email;
    private Gender gender;

    private final SecurityQuestion question;
    private final String answer;

    private boolean stayLoggedIn;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public Gender getGender() {
        return gender;
    }
    public SecurityQuestion getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public boolean isStayLoggedIn() {
        return stayLoggedIn;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z0-9-]+$";
        return username.matches(regex);
    }
    public static boolean isValidEmail(String email) {
        String regex = "^(?!.*\\.\\.)(?:[A-Za-z0-9](?:[A-Za-z0-9._-]*[A-Za-z0-9])?)@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
    public static boolean isValidPassword(String password) {
        String regex = "^[a-zA-Z0-9?<>,\"';:\\\\/|\\]\\[}{+=)(*&^%$#!]+$";
        return password.matches(regex);
    }
    public static String sha256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available" + e);
        }
    }

    public Player(String name, String username, String password,
                  String email, Gender gender, SecurityQuestion question,
                  String answer) {
        super(name);
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.question = question;
        this.answer = answer;
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

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

    @Override
    public String toString() {
        return "@";
    }
}