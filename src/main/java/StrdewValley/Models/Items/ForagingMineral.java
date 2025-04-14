package StrdewValley.Models.Items;

public class ForagingMineral extends Item{

    public ForagingMineral(String name, int sellPrice) {
        super(name, sellPrice);
    }

    @Override
    public Item copy() {
        return null;
    }
}