package org.example.config.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.context.Game;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public final class GameRepo {
    private static final Path DIR = Paths.get("data", "games");
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private GameRepo() {}

    public static void save(Game g) {
        try {
            Files.createDirectories(DIR);
            Path file = DIR.resolve("game_" + g.getId() + ".json");
            try (Writer w = Files.newBufferedWriter(file, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING)){
                GSON.toJson(g, w);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write game file", e);
        }
    }

    public static void delete(Game g) {
        Path file = DIR.resolve("game_" + g.getId() + ".json");
        try {
            Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot delete game file", e);
        }
    }

    public static Game load(int id) {
        Path file = DIR.resolve("game_" + id + ".json");
        if (!Files.exists(file))
            throw new IllegalStateException("Game " + id + " does not exist");

        try (Reader r = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            return GSON.fromJson(r, Game.class);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read game file", e);
        }
    }

    public static Optional<Game> tryLoad(int id) {
        try {
            return Optional.of(load(id));
        } catch (IllegalStateException ex){
            return Optional.empty();
        }
    }
}