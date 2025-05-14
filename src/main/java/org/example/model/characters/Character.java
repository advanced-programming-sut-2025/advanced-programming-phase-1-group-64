package org.example.model.characters;

import org.example.controller.EventBus;

public abstract class Character {
    protected String nickname;

    public Character(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
        EventBus.post(new PlayerChanged((Player) this));
    }
}