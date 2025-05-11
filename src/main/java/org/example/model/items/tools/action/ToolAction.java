package org.example.model.items.tools.action;

import org.example.model.characters.Player;
import org.example.model.items.Item;
import org.example.model.world.Cell;

public interface ToolAction {
    boolean use(Player player, Cell target);
}
