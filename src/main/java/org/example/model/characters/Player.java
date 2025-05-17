package org.example.model.characters;

import org.example.controller.EventBus;
import org.example.model.characters.ability.Ability;
import org.example.model.characters.inventory.Inventory;
import org.example.model.context.Game;
import org.example.model.items.Item;
import org.example.model.items.extra.CopyItem;
import org.example.model.world.Cell;
import org.example.model.world.buildings.Greenhouse;
import org.example.model.world.buildings.Home;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

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
    public void setUsername(String username) {
        this.username = username;
        EventBus.post(new PlayerChanged(this));
    }
    public void setPassword(String password) {
        password = sha256(password);
        this.password = password;
        EventBus.post(new PlayerChanged(this));
    }
    public boolean equalsPassword(String password) {
        return this.password.equals(sha256(password));
    }
    public void setEmail(String email) {
        this.email = email;
        EventBus.post(new PlayerChanged(this));
    }
    public int getHighEarnedPoints() {return highEarnedPoints;}
    public int getGamesPlayed() {return gamesPlayed;}

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
        if (password.length()<8) {
            System.out.printf("Password must be at least 8 characters");
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            System.out.printf("Password must contain at least one lowercase letter");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            System.out.printf("Password must contain at least one uppercase letter");
            return false;
        }
        if (!password.matches(".*[!#$%^&*)(=+}{\\]\\[|/\\\\:;'\",><?].*")) {
            System.out.printf("Password must contain at least one special character");
            return false;
        }
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
        EventBus.post(new PlayerChanged(this));
    }

    private boolean isInGame;
    private int currentGameId;

    public boolean isInGame() {
        return isInGame;
    }
    public void setInGame(boolean inGame) {
        isInGame = inGame;
        EventBus.post(new PlayerChanged(this));
    }

    public int getCurrentGameId() {
        return currentGameId;
    }
    public void setCurrentGame(int id) {
        this.currentGameId = id;
        EventBus.post(new PlayerChanged(this));
    }

    private int turnEnergy;
    private int maxTurnEnergy = 50;
    private int currentEnergy;
    private int maxEnergy = 200;
    private boolean fainted;

    public int getTurnEnergy() {
        return turnEnergy;
    }
    public void setTurnEnergy(int turnEnergy) {
        this.turnEnergy = turnEnergy;
    }
    public int getMaxTurnEnergy() {
        return maxTurnEnergy;
    }
    public void setMaxTurnEnergy(int maxTurnEnergy) {
        this.maxTurnEnergy = maxTurnEnergy;
    }

    private transient Cell cell;
    private int cellX;
    private int cellY;

    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
        this.cellX = cell.getX();
        this.cellY = cell.getY();
    }

    private Ability farming,mining,foraging, fishing;
    private transient Inventory inventory;
    private Greenhouse greenhouse;
    private transient Home home;
    private Set<String> knownCraftingRecipes;

    public Ability farming() {
        return farming;
    }
    public Ability mining() {
        return mining;
    }
    public Ability foraging() {
        return foraging;
    }
    public Ability fishing() {
        return fishing;
    }
    public void setFarming(Ability farming) {
        this.farming = farming;
        EventBus.post(new PlayerChanged(this));
    }
    public void setMining(Ability mining) {
        this.mining = mining;
        EventBus.post(new PlayerChanged(this));
    }
    public void setForaging(Ability foraging) {
        this.foraging = foraging;
        EventBus.post(new PlayerChanged(this));
    }
    public void setFishing(Ability fishing) {
        this.fishing = fishing;
        EventBus.post(new PlayerChanged(this));
    }

    public Inventory inventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        EventBus.post(new PlayerChanged(this));
    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }
    public void setGreenhouse(Greenhouse greenhouse) {
        this.greenhouse = greenhouse;
        EventBus.post(new PlayerChanged(this));
    }
    public Home getHome() {
        return home;
    }
    public void setHome(Home home) {
        this.home = home;
        EventBus.post(new PlayerChanged(this));
    }

    public Set<String> getKnownCraftingRecipes() {
        return knownCraftingRecipes;
    }
    public void setKnownCraftingRecipes(Set<String> knownCraftingRecipes) {
        this.knownCraftingRecipes = knownCraftingRecipes;
        EventBus.post(new PlayerChanged(this));
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
        EventBus.post(new PlayerChanged(this));
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }
    public void costCurrentEnergy(int currentEnergy) {
        this.currentEnergy -= currentEnergy;
        this.fainted = (this.currentEnergy == 0);
        EventBus.post(new PlayerChanged(this));
    }
    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
        this.fainted = (this.currentEnergy == 0);
        EventBus.post(new PlayerChanged(this));
    }

    public boolean isFainted() {
        return fainted;
    }
    public void setFainted(boolean fainted) {
        this.fainted = fainted;
        EventBus.post(new PlayerChanged(this));
    }

    public void setStayLoggedIn(boolean stayLoggedIn) {
        this.stayLoggedIn = stayLoggedIn;
        EventBus.post(new PlayerChanged(this));
    }

    public void unlockRecipe(String itemName) {
        if (knownCraftingRecipes.add(itemName)) {
            EventBus.post(new PlayerChanged(this));
        }
    }

    public boolean buildGreen(Game g){
        CopyItem wood = new CopyItem("Wood", 0);
        if(inventory.getItems().get(wood) >= Greenhouse.WOOD_COST){
            if(g.getPoints().get(this) >= Greenhouse.COIN_COST){
                inventory.deleteItem("Wood", Greenhouse.WOOD_COST, g, this);
                int coins = g.getPoints().get(this);
                g.getPoints().put(this, coins - Greenhouse.COIN_COST);
                greenhouse.build();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "@";
    }
}