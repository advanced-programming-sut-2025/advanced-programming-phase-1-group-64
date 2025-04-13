package StrdewValley.Models.NPC;

import StrdewValley.Models.Items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Quest{
    private String questDescription;
    private Boolean isComplete;
    private ArrayList<Item> requestItems;
    private ArrayList<Item> rewardItems;

    public Quest(String questDescription,
                 ArrayList<Item> requestItems,
                 ArrayList<Item> rewardItems) {
        this.questDescription = questDescription;
        this.isComplete = false;
        this.requestItems = requestItems;
        this.rewardItems = rewardItems;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public Boolean isCompleted() {
        return isComplete;
    }

    public ArrayList<Item> completeQuest(ArrayList<Item> requestItems){
        // if requestItems = this.requestItems , isComplete = false -> return rewardItems , isComplete = true
    }
}
