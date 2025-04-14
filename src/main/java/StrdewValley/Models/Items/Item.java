package StrdewValley.Models.Items;

public abstract class Item {
    protected String name;
    protected int price;
    protected ItemBehavior behavior;

    public Item(String name, int price) {
        this(name, price, new NoOpBehavior());
    }
    public Item(String name, int price, ItemBehavior behavior){
        this.name = name;
        this.price = price;
        this.behavior = behavior != null ? behavior : new NoOpBehavior();
    }
    public void use(){
        behavior.execute();
    }
    public abstract Item copy();
}