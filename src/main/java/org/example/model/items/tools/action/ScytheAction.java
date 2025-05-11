package org.example.model.items.tools.action;

import org.example.model.characters.Player;
import org.example.model.world.Cell;

public class ScytheAction implements ToolAction {
    @Override
    public boolean use(Player player, Cell target) {
        return false;
    }
}
