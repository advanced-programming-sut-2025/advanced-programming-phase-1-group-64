package com.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUpScreen implements Screen {
    private final Game game;
    private final Skin skin;
    private Stage stage;
    private TextField usernameField, passwordField, confirmPasswordField, emailField, nicknameField, securityAnswerField;
    private Texture viewIconTexture, hideIconTexture,diceIconTexture;
    private SelectBox<String> genderSelectBox, securityQuestionSelectBox;
    private Label statusLabel;

    private final Array<String> securityQuestions = new Array<>(new String[]{
        "What was your first pet's name?",
        "What is your mother's maiden name?",
        "What was the name of your elementary school?",
        "In what city were you born?",
        "What is your favorite book?"
    });

    public SignUpScreen(Game game, Skin skin) {
        this.game = game;
        this.skin = skin;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        viewIconTexture = new Texture(Gdx.files.internal("view.png"));
        hideIconTexture = new Texture(Gdx.files.internal("hide.png"));
        diceIconTexture = new Texture(Gdx.files.internal("dice.png"));

        Table table = new Table();
        table.setFillParent(true);
        table.center();
        stage.addActor(table);

        Label titleLabel = new Label("Create Account", skin, "Bold");
        titleLabel.setFontScale(1.5f);
        table.add(titleLabel).colspan(2).padBottom(20);
        table.row();

        table.add(new Label("Username:", skin)).right().padRight(10);
        usernameField = new TextField("", skin);
        table.add(usernameField).width(400).fillX();
        table.row().padTop(10);

        table.add(new Label("Nickname:", skin)).right().padRight(10);
        nicknameField = new TextField("", skin);
        table.add(nicknameField).width(400).fillX();
        table.row().padTop(10);

        table.add(new Label("Email:", skin)).right().padRight(10);
        emailField = new TextField("", skin);
        table.add(emailField).width(400).fillX();
        table.row().padTop(10);

        Table passwordRow = new Table();
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');
        passwordRow.add(passwordField).growX();

        ImageButton toggleVisibilityButton = new ImageButton(new TextureRegionDrawable(viewIconTexture));
        ImageButton randomPassButton = new ImageButton(new TextureRegionDrawable(diceIconTexture));
        passwordRow.add(toggleVisibilityButton).padLeft(10);
        passwordRow.add(randomPassButton).padLeft(5);

        table.add(new Label("Password:", skin)).right().padRight(10);
        table.add(passwordRow).width(543).fillX().padLeft(143);
        table.row().padTop(10);

        table.add(new Label("Confirm Password:", skin)).right().padRight(10);
        confirmPasswordField = new TextField("", skin);
        confirmPasswordField.setPasswordMode(true);
        confirmPasswordField.setPasswordCharacter('*');
        table.add(confirmPasswordField).width(400).fillX();
        table.row().padTop(10);

        table.add(new Label("Gender:", skin)).right().padRight(10);
        genderSelectBox = new SelectBox<>(skin);
        genderSelectBox.setItems("Male", "Female");
        table.add(genderSelectBox).width(400).fillX();
        table.row().padTop(10);

        table.add(new Label("Security Question:", skin)).right().padRight(10);
        securityQuestionSelectBox = new SelectBox<>(skin);
        securityQuestionSelectBox.setItems(securityQuestions);
        table.add(securityQuestionSelectBox).width(400).fillX();
        table.row().padTop(10);

        table.add(new Label("Answer:", skin)).right().padRight(10);
        securityAnswerField = new TextField("", skin);
        table.add(securityAnswerField).width(400).fillX();
        table.row().padTop(20);

        statusLabel = new Label("", skin);
        statusLabel.setAlignment(Align.center);
        table.add(statusLabel).colspan(2).growX();
        table.row().padTop(10);

        TextButton backButton = new TextButton("Back", skin);
        TextButton signUpButton = new TextButton("Sign Up", skin);
        Table buttonTable = new Table();
        buttonTable.add(backButton).width(150).height(75).padRight(20);
        buttonTable.add(signUpButton).width(150).height(75);
        table.add(buttonTable).colspan(2).padTop(20);

        toggleVisibilityButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                boolean isPassword = passwordField.isPasswordMode();
                passwordField.setPasswordMode(!isPassword);
                confirmPasswordField.setPasswordMode(!isPassword);

                ImageButton button = (ImageButton) actor;
                if (isPassword) {
                    button.getStyle().imageUp = new TextureRegionDrawable(hideIconTexture);
                } else {
                    button.getStyle().imageUp = new TextureRegionDrawable(viewIconTexture);
                }
            }
        });

        randomPassButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String randomPassword = generateRandomPassword();
                passwordField.setText(randomPassword);
                confirmPasswordField.setText(randomPassword);
            }
        });

        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new PreGameScreen(game, skin));
            }
        });

        signUpButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sendSignupRequest();
            }
        });
    }

    private void sendSignupRequest() {
        String username = usernameField.getText().trim();
        String nickname = nicknameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String gender = genderSelectBox.getSelected();
        String securityQuestion = securityQuestionSelectBox.getSelected();
        String securityAnswer = securityAnswerField.getText().trim();

        if (username.isEmpty() || nickname.isEmpty() || email.isEmpty() || password.isEmpty() || securityAnswer.isEmpty()) {
            statusLabel.setText("All fields are required!");
            statusLabel.setColor(Color.RED);
            return;
        }

        if (!username.matches("^[a-zA-Z0-9-]+$")) {
            statusLabel.setText("Username can only contain letters, numbers, and hyphens.");
            statusLabel.setColor(Color.RED);
            return;
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String symbols = "?<>,'\";:\\/|\\[\\](){}+=!#$%.^&*";
        if (!email.matches(emailRegex)) {
            statusLabel.setText("Invalid email format.");
            statusLabel.setColor(Color.RED);
            return;
        }

        if (password.length() < 8) {
            statusLabel.setText("Password must be at least 8 characters long.");
            statusLabel.setColor(Color.RED);
            return;
        }

        if (!password.matches(".*[a-z].*")) {
            statusLabel.setText("Password must contain at least one lowercase letter.");
            statusLabel.setColor(Color.RED);
            return;
        }

        if (!password.matches(".*[A-Z].*")) {
            statusLabel.setText("Password must contain at least one uppercase letter.");
            statusLabel.setColor(Color.RED);
            return;
        }

        if (!password.matches(".*\\d.*")) {
            statusLabel.setText("Password must contain at least one number.");
            statusLabel.setColor(Color.RED);
            return;
        }

        if (!password.matches(".*[" + symbols.replace("\\", "\\\\").replace("[", "\\[").replace("]", "\\]") + "].*")) {
            statusLabel.setText("Password must contain at least one special symbol.");
            statusLabel.setColor(Color.RED);
            return;
        }

        if (!Objects.equals(password, confirmPassword)) {
            statusLabel.setText("Passwords do not match!");
            statusLabel.setColor(Color.RED);
            return;
        }

        statusLabel.setText("Connecting to server...");
        statusLabel.setColor(Color.YELLOW);

        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("nickname", nickname);
        data.put("password", password);
        data.put("email", email);
        data.put("gender", gender);
        data.put("securityQuestion", securityQuestion);
        data.put("securityAnswer", securityAnswer);

        Net.HttpRequest request = new Net.HttpRequest(Net.HttpMethods.POST);
        request.setUrl("http://localhost:8080/signup");
        request.setHeader("Content-Type", "application/json");
        request.setContent(new com.google.gson.Gson().toJson(data));

        Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                int statusCode = httpResponse.getStatus().getStatusCode();
                final String responseBody = httpResponse.getResultAsString();

                Gdx.app.postRunnable(() -> {
                    if (statusCode == 201) {
                        statusLabel.setText("Account created successfully!");
                        statusLabel.setColor(Color.GREEN);
                        Gdx.app.log("SIGNUP", "Success: " + responseBody);
                    } else {
                        statusLabel.setText("Error! Could not create account.");
                        statusLabel.setColor(Color.RED);
                        Gdx.app.error("SIGNUP", "Failed (" + statusCode + "): " + responseBody);
                    }
                });
            }

            @Override
            public void failed(Throwable throwable) {
                Gdx.app.postRunnable(() -> {
                    statusLabel.setText("Connection failed. Check the server.");
                    statusLabel.setColor(Color.RED);
                    Gdx.app.error("SIGNUP", "Connection error", throwable);
                });
            }

            @Override
            public void cancelled() {
                /* ... */
            }
        });
    }

    private String generateRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(new Color(0.1f, 0.4f, 0.2f, 1));
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
