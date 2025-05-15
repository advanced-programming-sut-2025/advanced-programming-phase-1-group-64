package org.example.config.repositories;

import com.google.gson.Gson;
import org.example.model.context.App;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StatRepo {
    private static final Path FILE = Paths.get("data", "stats.json");
    private static final Gson GSON = new Gson();

    private StatRepo() {}

    public static void load(){
        if(!Files.exists(FILE)) return;

        try (Reader r = Files.newBufferedReader(FILE, StandardCharsets.UTF_8)) {
            Integer n = GSON.fromJson(r, Integer.class);
            if (n != null) App.setGamesWasCreated(n);
        } catch (IOException e){
            throw new IllegalStateException("cannot read stats.json", e);
        }
    }

    public static void save(){
        try {
            Files.createDirectories(FILE.getParent());
            try (Writer w = Files.newBufferedWriter(FILE, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING)) {
                GSON.toJson(App.getGamesWasCreated(), w);
            }
        } catch (IOException e) {
            throw new IllegalStateException("cannot write stats.json", e);
        }
    }
}