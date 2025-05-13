package org.example.model.characters;

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
    }
}