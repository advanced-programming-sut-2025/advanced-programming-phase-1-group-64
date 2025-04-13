package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.GameTime;
import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Season;
import StrdewValley.Models.Time;

import javax.crypto.SealedObject;
import java.util.ArrayList;

public class Item {
    private String itemName;
    private String itemSource;
    private int[] stages;
    private Boolean oneTime;
    private Time regrowthTime;
    private int baseSellPrice;
    private Boolean isEdible;
    private int energy;
    private SeasonType[] season;
    private Boolean canBecomeGiant;

    public Item(String itemName, String itemSource, int[] stages, Boolean oneTime,
                Time regrowthTime, int baseSellPrice, Boolean isEdible, int energy, SeasonType[] season, Boolean canBecomeGiant) {
        this.itemName = itemName;
        this.itemSource = itemSource;
        this.stages = stages;
        this.oneTime = oneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.energy = energy;
        this.season = season;
        this.canBecomeGiant = canBecomeGiant;
    }

    public Time getTotalHarvestTime(){
        int sum = 0;
        for(int i : stages) {
            sum += i;
        }
        //TODO
        return new Time();
    }
}
