package org.example.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.items.foragings.MineralSpec;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class MineralConfig {
    private static final Map<String, MineralSpec> MAP = load();

    private static Map<String,MineralSpec> load() {
        String resource = "data/foraging/foraging_minerals.json";
        InputStream in = MineralConfig.class.getClassLoader()
                .getResourceAsStream(resource);

        if (in == null)
            throw new IllegalStateException("Resource '"+resource+"' not found in classpath!");

        try (Reader r = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            Type t = new TypeToken<Map<String,MineralSpec>>(){}.getType();
            return Collections.unmodifiableMap(new Gson().fromJson(r, t));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read "+resource, e);
        }
    }
    public static MineralSpec get(String name){ return MAP.get(name); }
    public static List<MineralSpec> all()      { return new ArrayList<>(MAP.values()); }
}