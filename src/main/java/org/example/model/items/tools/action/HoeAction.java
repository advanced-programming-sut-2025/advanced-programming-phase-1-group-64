package org.example.model.items.tools.action;

import org.example.model.characters.Player;
import org.example.model.items.tools.Tool;
import org.example.model.items.tools.quality.ToolQuality;
import org.example.model.world.Cell;
import org.example.model.world.CellKind;

public class HoeAction implements ToolAction {
    @Override
    public boolean use(Player player, Cell target, Tool tool) {
        int energy = player.getTurnEnergy();
        int energyCost = tool.getSpec().getEnergyCost(tool.getToolQuality());
        if (player.farming().isMax())
            energyCost -= 1;
        if (target.getKind() == CellKind.EMPTY){
            if (energy >= energyCost) {
                target.setKind(CellKind.PLOW);
                player.setCurrentEnergy(energy - energyCost);
                System.out.println("Tool uses successfully");
                return true;
            }
            System.out.println("Tool uses not enough energy");
        } else {
            if (energy >= energyCost)
                player.setCurrentEnergy(energy - energyCost);
            System.out.println("Is not a good cell");
        }
        return false;
    }
}