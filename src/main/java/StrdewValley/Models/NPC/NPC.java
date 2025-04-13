package StrdewValley.Models.NPC;

import StrdewValley.Models.Character;
import StrdewValley.Models.Items.Item;

import java.util.ArrayList;

public class NPC extends Character {
    private String NPCName;
    private ArrayList<String> dialogs;
    private ArrayList<Item> lovelyItems;
    private ArrayList<Quest> quests;

    public NPC(String NPCName, ArrayList<String> dialogs, ArrayList<Item> lovelyItems, ArrayList<Quest> quests) {
        this.NPCName = NPCName;
        this.dialogs = dialogs;
        this.lovelyItems = lovelyItems;
        this.quests = quests;
    }
}
