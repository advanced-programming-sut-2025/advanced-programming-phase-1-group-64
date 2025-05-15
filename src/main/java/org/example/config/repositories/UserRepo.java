package org.example.config.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.controller.EventBus;
import org.example.model.characters.Player;
import org.example.model.characters.PlayerChanged;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class UserRepo {
    private static final Path FILE = Paths.get("data", "users.json");
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    private final Map<String, Player> users = new HashMap<>();

    private static final UserRepo INSTANCE = new UserRepo();
    public static UserRepo get(){return INSTANCE;}
    private UserRepo() {
        load();
        EventBus.register(PlayerChanged.class, evt -> save());
    }

    public synchronized Collection<Player> all() { return users.values(); }
    public synchronized Player find(String user){ return users.get(user); }
    public synchronized boolean exists(String user){ return users.containsKey(user);}

    public synchronized boolean add(Player player){
        String key = player.getUsername();
        if (users.containsKey(key)) return false;
        users.put(key, player);
        save();
        return true;
    }

    private void load(){
        if (!Files.exists(FILE)) return;
        try (Reader r = Files.newBufferedReader(FILE, StandardCharsets.UTF_8)) {
             Type mapType = new TypeToken<Map<String, Player>>(){}.getType();
             Map<String, Player> fromDisk = GSON.fromJson(r, mapType);
             if (fromDisk != null) users.putAll(fromDisk);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read users.json", e);
        }
    }

    public void save() {
        try {
            Files.createDirectories(FILE.getParent());
            try (Writer w = Files.newBufferedWriter(FILE, StandardCharsets.UTF_8,
                                                    StandardOpenOption.CREATE,
                                                    StandardOpenOption.TRUNCATE_EXISTING)) {
                GSON.toJson(users, w);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write users.json", e);
        }
    }

    public synchronized Player findStayLoggedIn(){
        return users.values()
                .stream()
                .filter(Player::isStayLoggedIn)
                .findFirst()
                .orElse(null);
    }
}