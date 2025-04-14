package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Time;

public class AllCropItem extends Item{
    private String cropSource;
    private int[] stages;
    private Boolean oneTime;
    private Time regrowthTime;
    private int baseSellPrice;
    private Boolean isEdible;
    private int energy;
    private SeasonType[] season;
    private Boolean canBecomeGiant;

    public AllCropItem(String cropName, String cropSource, int[] stages, Boolean oneTime,
                       Time regrowthTime, int baseSellPrice, Boolean isEdible, int energy, SeasonType[] season, Boolean canBecomeGiant) {
        super(cropName);
        this.cropSource = cropSource;
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