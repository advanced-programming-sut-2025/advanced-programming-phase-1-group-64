//package org.example.config;
//
////import com.google.gson.*;
//import org.example.model.items.trees.TreeSpec;
//import org.example.model.world.time.SeasonType;
//
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
//public final class TreeConfig {
//    private static final Map<String, TreeSpec> TREE_SPECS = new HashMap<>();
//
//    static {
//        try(var reader = new InputStreamReader(
//                Objects.requireNonNull(TreeConfig.class.getResourceAsStream("/data/trees.json")),
//                StandardCharsets.UTF_8)) {
//
//            Gson gson = new GsonBuilder()
//                    .registerTypeAdapter(
//                            new com.google.gson.reflect.TypeToken<EnumSet<SeasonType>>(){}.getType(),
//                            (JsonDeserializer<EnumSet<SeasonType>>) (json, type, ctx) ->
//                                    SeasonType.parseList(json.getAsString()))
//                    .create();
//
//            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
//            for (Map.Entry<String, JsonElement> e : root.entrySet()) {
//                String name = e.getKey();
//                JsonObject obj = e.getValue().getAsJsonObject();
//
//                int[] stages = gson.fromJson(obj.get("stages"), int[].class);
//                EnumSet<SeasonType> seasons = SeasonType.parseList(obj.get("seasons").getAsString());
//
//                TreeSpec spec = new TreeSpec(
//                        name,
//                        obj.get("sourceName").getAsString(),
//                        stages,
//                        obj.get("totalHarvestTime").getAsInt(),
//                        obj.get("fruit").getAsString(),
//                        obj.get("fruitHarvestCycle").getAsInt(),
//                        obj.get("fruitBaseSellPrice").getAsInt(),
//                        obj.get("edible").getAsBoolean(),
//                        obj.get("energy").isJsonNull()? null : obj.get("energy").getAsInt(),
//                        seasons
//                );
//                TREE_SPECS.put(name, spec);
//            }
//
//        }catch (Exception e) {
//            throw new ExceptionInInitializerError("Cannot load trees.json: " + e);
//        }
//    }
//
//    public static TreeSpec getTreeSpec(String name) { return TREE_SPECS.get(name); }
//    public static Collection<TreeSpec> all() { return TREE_SPECS.values(); }
//}