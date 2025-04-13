package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;

public enum AllCropType {
    BLUE_JAZZ(new AllCropItem("Blue Jazz","Jazz",new int[]{1, 2, 2, 2, 7},true,null,
            50,true,45,new SeasonType[]{SeasonType.SPRING},false ));
    //TODO

    private final AllCropItem cropItem;

    AllCropType(AllCropItem cropItem) {
        this.cropItem = cropItem;
    }
}