package com.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

public class StartScreen implements Screen {
    private final Game game;
    private SpriteBatch batch;
    private Texture background;
    private float timer = 0f;
    private final Skin skin;

    public StartScreen(Game game, Skin skin) {
        this.game = game;
        this.skin = skin;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Texture("start_screen/start_icon.png");
    }

    @Override
    public void render(float v) {
        timer += v;

        if (timer >= 2f) {
            game.setScreen(new PreGameScreen(game, skin));
            return;
        }

        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float imageWidth = background.getWidth();
        float imageHeight = background.getHeight();

        float x = (screenWidth - imageWidth) / 2;
        float y = (screenHeight - imageHeight) / 2;

        batch.draw(background, x, y, imageWidth, imageHeight);
        batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        background.dispose();
        batch.dispose();
    }
}
