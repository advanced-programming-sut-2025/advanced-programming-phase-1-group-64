package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Time;

public enum TreeType {
    APRICOT_TREE(new Tree("Apricot Tree","Apricot Sapling","Apricot",new Time(1),
            59,true,38,new SeasonType[]{SeasonType.SPRING}));
    //TODO

    private final Tree tree;

    TreeType(Tree tree) {
        this.tree = tree;
    }
}