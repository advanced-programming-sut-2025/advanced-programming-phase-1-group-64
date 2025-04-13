package StrdewValley.Models.NPC;

public enum NPCs {
    SEBASTIAN(new NPC()); //Should Complete


    private final NPC npc;

    NPCs(NPC npc) {
        this.npc = npc;
    }

    public Quest getQuest() {
        return quest;
    }
}
