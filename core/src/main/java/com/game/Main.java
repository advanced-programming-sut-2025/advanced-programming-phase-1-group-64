package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.model.GameAssetManager;
import com.game.view.PreGameScreen;
import com.game.view.StartScreen;

public class Main extends Game {
    private static Main main;
    private GameAssetManager assetManager;

    @Override
    public void create() {
        assetManager = GameAssetManager.getInstance();
        assetManager.loadAssets();
        main = this;
    }

    @Override
    public void render() {
        super.render();

        if (assetManager.manager.update()) {
            if (getScreen() == null) {
                main.setScreen(new StartScreen(this, assetManager.getSkin()));
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        assetManager.dispose();
    }

    public static Main getMain() {
        return main;
    }

    public static void setMain(Main main) {
        Main.main = main;
    }
}
