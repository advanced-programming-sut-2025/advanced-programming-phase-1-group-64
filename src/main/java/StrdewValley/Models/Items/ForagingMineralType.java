package StrdewValley.Models.Items;

public enum ForagingMineralType {
    QUARTZ(new ForagingMineral("Quartz",25));
    //TODO

    private final ForagingMineral foragingMineral;

    ForagingMineralType(ForagingMineral foragingMineral) {
        this.foragingMineral = foragingMineral;
    }
}