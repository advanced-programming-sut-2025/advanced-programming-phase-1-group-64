package org.example.model.world.buildings;

import java.util.ArrayList;

public class Greenhouse {
    public static final int WOOD_COST = 500;
    public static final int COIN_COST = 1000;
    private boolean built;

    public Greenhouse() {
        this.built = false;
    }

    public void build(){
        built = true;
    }

    public boolean isBuilt() {
        return built;
    }
}