package org.example.config.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.items.craftings.Recipe;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collections;
import java.util.Map;

public final class CraftingRepo {
    private static final Path FILE = Paths.get("data","crafting","ingredients.json");
    private static final Gson GSON =
            new GsonBuilder().setPrettyPrinting().create();
    private static final Map<String, Recipe> RECIPES = loadOnce();

    private CraftingRepo() {}

    public static Recipe get(String itemName){
        return RECIPES.get(itemName);
    }
    public static Map<String, Recipe> all(){ return RECIPES; }

    private static Map<String, Recipe> loadOnce() {
        if (!Files.exists(FILE))
            throw new IllegalStateException("ingredients.json not found" + FILE);

        Type mapType = new TypeToken<Map<String, Recipe>>() {}.getType();
        try (Reader r = Files.newBufferedReader(FILE, StandardCharsets.UTF_8)){
            Map<String, Recipe> tmp = GSON.fromJson(r, mapType);
            return Collections.unmodifiableMap(tmp);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read " + FILE, e);
        }
    }
}