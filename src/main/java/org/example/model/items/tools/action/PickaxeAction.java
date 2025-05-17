package org.example.model.items.tools.action;

import org.example.model.characters.Player;
import org.example.model.items.extra.CopyItem;
import org.example.model.items.foragings.MineralSpec;
import org.example.model.items.tools.Tool;
import org.example.model.world.Cell;
import org.example.model.world.CellKind;

public class PickaxeAction implements ToolAction {
    @Override
    public boolean use(Player player, Cell target, Tool tool) {
        int energy = player.getTurnEnergy();
        int energyCost = tool.getSpec().getEnergyCost(tool.getToolQuality());
        if(player.mining().isMax())
            energyCost -= 1;
        if (target.getKind() == CellKind.MINE){
            if(target.getObject() instanceof MineralSpec){
                if (energy >= energyCost){
                    MineralSpec spec = (MineralSpec) target.getObject();
                    CopyItem item = new CopyItem(spec.getName(), spec.getSellPrice());
                    player.inventory().add(item,1);
                    target.setKind(CellKind.MINE);
                    player.setCurrentEnergy(energy - energyCost);
                    System.out.println(spec.getName() + " added to inventory");
                    player.mining().addXp(10);
                    return true;
                }
                System.out.println("Tool uses not enough energy");
                return false;
            }
            energyCost = Math.max(energyCost-1, 0);
            player.setCurrentEnergy(energy - energyCost);
            System.out.println("It is not a good cell");
            return false;
        }else if(target.getKind() == CellKind.PLOW){
            if (energy >= energyCost) {
                target.setKind(CellKind.EMPTY);
                player.setCurrentEnergy(energy - energyCost);
                System.out.println("Tool uses successfully");
                return true;
            }
            System.out.println("Tool uses not enough energy");
            return false;
        }else {
            energyCost = Math.max(energyCost-1, 0);
            player.setCurrentEnergy(energy - energyCost);
            System.out.println("It is not a good cell");
            return false;
        }
    }
}