package org.example.model.items.craftings;

import org.example.model.characters.ability.AbilityType;
import org.example.model.items.craftings.bombs.Bomb;
import org.example.model.items.craftings.bombs.BombType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CraftingRegistry {
    private static final Map<String, CraftingItem> ITEMS = new HashMap<>();

    static {
        ITEMS.put("Cherry Bomb", new Bomb(BombType.CHERRY));
        //
    }

    private CraftingRegistry() {}

    public static List<CraftingItem>
    getByAbilityType(AbilityType t, int lvl) {
        return ITEMS.values().stream()
                .filter(ci -> ci.getAbilitySource() == t
                        && ci.getLevelSource() <= lvl)
                .toList();
    }

    public static CraftingItem get(String name){return ITEMS.get(name);}
}