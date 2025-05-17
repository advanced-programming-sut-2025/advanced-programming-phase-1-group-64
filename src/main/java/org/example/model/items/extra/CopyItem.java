package org.example.model.items.extra;

import org.example.model.items.Item;

public class CopyItem extends Item {
    public CopyItem(String name, int basePrice) {
        super(name, basePrice);
    }

    public static CopyItem createItem(String name, int basePrice) {
        return new CopyItem(name, basePrice);
    }
}
