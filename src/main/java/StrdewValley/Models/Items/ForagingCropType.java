package StrdewValley.Models.Items;

import StrdewValley.Models.Enums.SeasonType;

public enum ForagingCropType {
    CommonMushroom(new ForagingCrop("Common Mushroom",
            new SeasonType[]{SeasonType.SPRING,SeasonType.SUMMER,SeasonType.FALL,SeasonType.WINTER},
            40,38));
    //TODO

    private final ForagingCrop foragingCrop;

    ForagingCropType(ForagingCrop foragingCrop) {
        this.foragingCrop = foragingCrop;
    }
}
