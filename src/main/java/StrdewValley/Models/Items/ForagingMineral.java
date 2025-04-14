package StrdewValley.Models.Items;

public class ForagingMineral extends Item{
    private int sellPrice;

    public ForagingMineral(String name, int sellPrice) {
        super(name);
        this.sellPrice = sellPrice;
    }
}