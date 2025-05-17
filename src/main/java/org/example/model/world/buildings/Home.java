package org.example.model.world.buildings;

import org.example.model.items.craftings.machines.Machine;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private final List<Machine> machines;

    public Home() {
        this.machines = new ArrayList<>();
    }

    public List<Machine> getMachines() {
        return machines;
    }
}