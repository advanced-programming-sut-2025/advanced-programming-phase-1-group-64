package org.example.model.items.craftings.machines;

import org.example.model.world.time.Time;

import java.util.Map;

public final class MachineRecipe {
    private final Map<String, Integer> inputs;

    private final String output;

    private final int processingTime;

    public MachineRecipe(Map<String, Integer> inputs, String output, int processingTime) {
        this.inputs = inputs;
        this.output = output;
        this.processingTime = processingTime;
    }

    public Map<String, Integer> getInputs() {
        return inputs;
    }
    public String getOutput() {
        return output;
    }
    public int getProcessingTime() {
        return processingTime;
    }
}