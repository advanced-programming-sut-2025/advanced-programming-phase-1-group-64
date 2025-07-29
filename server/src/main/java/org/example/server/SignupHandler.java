package org.example.server;

import com.game.model.User;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jakarta.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SignupHandler implements HttpHandler {
    private final Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responseMessage;
        int statusCode = 200;

        try {
            if (!"POST".equals(exchange.getRequestMethod())) {
                throw new UnsupportedOperationException("Only POST method is allowed");
            }

            InputStream requestBody = exchange.getRequestBody();
            String jsonPayload = new String(requestBody.readAllBytes(), StandardCharsets.UTF_8);
            Map<String, String> data = gson.fromJson(jsonPayload, Map.class);

            User newUser = new User();
            newUser.setUsername(data.get("username"));
            newUser.setEmail(data.get("email"));
            newUser.setPassword(data.get("password"));
            newUser.setNickname(data.get("nickname"));
            newUser.setGender(User.Gender.valueOf(data.get("gender").toUpperCase()));
            newUser.setSecurityQuestion(data.get("securityQuestion"));
            newUser.setSecurityAnswer(data.get("securityAnswer"));

            DatabaseManager.saveUser(newUser);

            statusCode = 201;
            responseMessage = "{\"message\":\"User created successfully\"}";

        } catch (PersistenceException e) {
            statusCode = 409;
            responseMessage = "{\"error\":\"Username already exists\"}";
            e.printStackTrace();
        } catch (Exception e) {
            statusCode = 500;
            responseMessage = "{\"error\":\"An unexpected error occurred\"}";
            e.printStackTrace();
        }

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, responseMessage.getBytes(StandardCharsets.UTF_8).length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseMessage.getBytes(StandardCharsets.UTF_8));
        }
    }
}
