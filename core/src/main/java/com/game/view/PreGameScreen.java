package com.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PreGameScreen implements Screen {
    private final Game game;
    private final Skin skin;
    private Stage stage;

    public PreGameScreen(Game game, Skin skin) {
        this.game = game;
        this.skin = skin;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label titleLabel = new Label("STARDEW\n VALLEY", skin, "Bold");
        titleLabel.setFontScale(2.0f);
        table.add(titleLabel).expandX().top().padTop(80);
        table.row();

        TextButton loginButton = new TextButton("LOGIN", skin);
        TextButton signUpButton = new TextButton("SIGN UP", skin);

        loginButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.setScreen(new LoginScreen(game, skin));
            }
        });

        signUpButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.setScreen(new SignUpScreen(game, skin));
            }
        });

        Table buttonTable = new Table();
        buttonTable.add(signUpButton).width(200).height(75).pad(10);
        buttonTable.add(loginButton).width(200).height(75).pad(10);

        table.add(buttonTable).expandY().bottom().padBottom(75);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.1f, 0.1f, 0.2f, 1);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
        stage.getViewport().update(i, i1, true);
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
        stage.dispose();
    }
}
