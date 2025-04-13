package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;
import StrdewValley.Models.Time;

import java.util.ArrayList;

public enum ItemsType {
    BLUE_JAZZ(new Item("Blue Jazz", "Jazz", new int[]{1, 2, 2, 2, 7},true, null, 50, true, 45, new SeasonType[]{SeasonType.SPRING}, false ));
    //TODO

    private final Item item;

    ItemsType(Item item) {
        this.item = item;
    }

}
