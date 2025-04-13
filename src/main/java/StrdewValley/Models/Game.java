package StrdewValley.Models;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ArrayList<User> usersInGame;
    private final HashMap<User, Map> mapOfUsers;
    private final Map totalMap;
    private User mainUser;
    private User turnOfUser;
    private int Turn;
    private Time time;
    private Season season;
}