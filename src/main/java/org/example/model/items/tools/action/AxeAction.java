package org.example.model.items.tools.action;

import org.example.model.characters.Player;
import org.example.model.items.tools.Tool;
import org.example.model.world.Cell;
import org.example.model.world.CellKind;

public class AxeAction implements ToolAction {
    @Override
    public boolean use(Player player, Cell target, Tool tool) {
        int energy = player.getTurnEnergy();
        int energyCost = tool.getSpec().getEnergyCost(tool.getToolQuality());
        if (player.foraging().isMax())
            energyCost -= 1;
        if (target.getKind() == CellKind.TREE){

        }else if (target.getKind() == CellKind.WOOD){

        }else {

        }
    }
}