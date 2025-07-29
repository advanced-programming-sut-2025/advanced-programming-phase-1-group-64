package org.example.server;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ServerLauncher {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        server.createContext("/signup", new SignupHandler());

        server.setExecutor(Executors.newFixedThreadPool(10));

        server.start();
        System.out.println("Server is listening on port " + PORT);
    }
}
