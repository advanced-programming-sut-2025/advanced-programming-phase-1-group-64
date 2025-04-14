package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Time;

public class Tree extends Item{
    private String treeSource;
    private int[] stages;
    private String fruit;
    private Time fruitHarvestCycle;
    private Boolean isFruitEdible;
    private int fruitEnergy;
    private SeasonType[] season;

    public Tree(String treeName, String treeSource, String fruit, Time fruitHarvestCycle,
                int fruitBaseSellPrice, Boolean isFruitEdible, int fruitEnergy, SeasonType[] season) {
        super(treeName, fruitBaseSellPrice);
        this.treeSource = treeSource;
        this.stages = new int[]{7,7,7,7};
        this.fruit = fruit;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.isFruitEdible = isFruitEdible;
        this.fruitEnergy = fruitEnergy;
        this.season = season;
    }

    @Override
    public Item copy() {
        return null;
    }
}