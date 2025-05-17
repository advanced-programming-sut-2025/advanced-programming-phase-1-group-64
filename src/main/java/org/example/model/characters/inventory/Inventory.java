package org.example.model.characters.inventory;

import org.example.model.characters.Player;
import org.example.model.context.Game;
import org.example.model.items.extra.CopyItem;
import org.example.model.items.extra.FoodItem;
import org.example.model.items.Item;
import org.example.model.items.tools.Tool;
import org.example.model.items.tools.ToolFactory;
import org.example.model.world.buildings.Greenhouse;

import java.util.HashMap;

public class Inventory {
    private BackpackQuality quality;
    private TrashQuality trash;
    private HashMap<Item, Integer> items;
    private int numberOfItems;
    private Tool currentTool;

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public boolean deleteItem(String itemName, Game game, Player player) {
        for (var entry : items.entrySet()) {
            if (entry.getKey().getName().equals(itemName)) {
                int money = entry.getKey().getBasePrice();
                money = (int) (money*trash.getReturningSalesValue());
                game.getPoints().put(player, game.getPoints().get(player) + money);
                items.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }
    public boolean deleteItem(String itemName, int number, Game game, Player player) {
        for (var entry : items.entrySet()) {
            if (entry.getKey().getName().equals(itemName)) {
                int numberOfItem = entry.getValue();
                if(number >= numberOfItem) {
                    int money = entry.getKey().getBasePrice();
                    money = (int) (money*trash.getReturningSalesValue());
                    game.getPoints().put(player, game.getPoints().get(player) + money);
                    items.remove(entry.getKey());
                    return true;
                }
                items.put(entry.getKey(), number - numberOfItem);
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName) {
        for (var entry : items.entrySet()) {
            if (entry.getKey().getName().equals(itemName)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Inventory() {
        this.quality = BackpackQuality.BASIC;
        this.trash = TrashQuality.BASIC;
        this.items = new HashMap<>();
        this.items.put(ToolFactory.makeHoe(), 1);
        this.items.put(ToolFactory.makePickaxe(), 1);
        this.items.put(ToolFactory.makeAxe(), 1);
        this.items.put(ToolFactory.makeWateringCan(), 1);
        this.items.put(ToolFactory.makeScythe(), 1);
        this.currentTool = (Tool) getItem("Hoe");
        this.numberOfItems = 5;
    }

    private void addItem(Item item, int quantity) {
        if (this.items.containsKey(item)) {
            this.items.put(item, this.items.get(item) + quantity);
        } else {
            if(this.quality.getSize() > this.numberOfItems){
                this.items.put(item, quantity);
                this.numberOfItems++;
            }
            else
                System.out.println("You can't add more than "+this.numberOfItems+" items");
        }
    }

    public void add(Item item, int quantity) {
        addItem(item, quantity);
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public void allTools() {
        for (var entry : items.entrySet()) {
            if(entry.getKey() instanceof Tool) {
                System.out.println(entry.getKey().getName());
            }
        }
    }
}