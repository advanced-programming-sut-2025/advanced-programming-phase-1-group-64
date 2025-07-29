package com.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {
    public final AssetManager manager = new AssetManager();
    public static final String SKIN_PATH = "skin/NzSkin.json";
    private static GameAssetManager instance;

    private GameAssetManager() {}

    public static GameAssetManager getInstance() {
        if (instance == null) {
            instance = new GameAssetManager();
        }
        return instance;
    }

    public void loadAssets() {
        manager.load(SKIN_PATH, Skin.class);
    }

    public Skin getSkin() {
        return manager.get(SKIN_PATH, Skin.class);
    }

    public void dispose() {
        manager.dispose();
    }
}
