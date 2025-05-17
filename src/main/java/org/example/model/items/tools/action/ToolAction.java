package org.example.model.items.tools.action;

import org.example.model.characters.Player;
import org.example.model.characters.inventory.TrashQuality;
import org.example.model.items.Item;
import org.example.model.items.tools.Tool;
import org.example.model.items.tools.quality.ToolQuality;
import org.example.model.world.Cell;

public interface ToolAction {
    boolean use(Player player, Cell target, Tool tool);
}
