package org.example.server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UsersHandler implements HttpHandler {
    private final Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responseMessage;
        int statusCode;

        try {
            if (!"GET".equals(exchange.getRequestMethod())) {
                statusCode = 405;
                responseMessage = "{\"error\":\"Only GET method is allowed\"}";
            } else {
                List<String> usernames = DatabaseManager.getAllUsernames();
                responseMessage = gson.toJson(usernames);
                statusCode = 200;
            }
        } catch (Exception e) {
            statusCode = 500;
            responseMessage = "{\"error\":\"An unexpected error occurred on the server\"}";
            e.printStackTrace();
        }

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, responseMessage.getBytes(StandardCharsets.UTF_8).length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseMessage.getBytes(StandardCharsets.UTF_8));
        }
    }
}
