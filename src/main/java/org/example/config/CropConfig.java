//package org.example.config;
//
////import com.google.gson.*;
//import org.example.model.items.crops.CropSpec;
//import org.example.model.world.time.SeasonType;
//
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
//public final class CropConfig {
//    private static final Map<String, CropSpec> CROP_SPECS = new HashMap<>();
//
//    static {
//        try(var reader = new InputStreamReader(
//                Objects.requireNonNull(CropConfig.class.getResourceAsStream("/data/crops.json")),
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
//                CropSpec spec = new CropSpec(
//                        name,
//                        obj.get("sourceName").getAsString(),
//                        stages,
//                        obj.get("totalHarvestTime").getAsInt(),
//                        obj.get("oneTime").getAsBoolean(),
//                        obj.get("regrowthTime").isJsonNull() ? null : obj.get("regrowthTime").getAsInt(),
//                        obj.get("baseSellPrice").getAsInt(),
//                        obj.get("edible").getAsBoolean(),
//                        obj.get("energy").isJsonNull() ? null : obj.get("energy").getAsInt(),
//                        seasons,
//                        obj.get("canBecomeGiant").getAsBoolean()
//                );
//                CROP_SPECS.put(name, spec);
//            }
//        } catch (Exception e) {
//            throw new ExceptionInInitializerError("Cannot load crops.json: " + e);
//        }
//    }
//
//    public static CropSpec getCropSpec(String name) { return CROP_SPECS.get(name); }
//    public static Collection<CropSpec> all() { return CROP_SPECS.values(); }
//}