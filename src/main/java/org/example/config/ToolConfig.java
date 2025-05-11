//package org.example.config;
//
////import com.google.gson.JsonElement;
////import com.google.gson.JsonObject;
////import com.google.gson.JsonParser;
//import org.example.model.items.tools.ToolSpec;
//import org.example.model.items.tools.quality.FishingQuality;
//import org.example.model.items.tools.quality.ToolQuality;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
//public final class ToolConfig {
//    private static final Map<String, ToolSpec> TOOL_SPECS = new HashMap<>();
//
//    static {
//        try(Reader r = new InputStreamReader(
//                Objects.requireNonNull(ToolConfig.class.getResourceAsStream("/data/tool_specs.json")),
//                StandardCharsets.UTF_8)) {
//            JsonObject root = JsonParser.parseReader(r).getAsJsonObject();
//            for (Map.Entry<String, JsonElement> e : root.entrySet()) {
//                String name = e.getKey();
//                JsonObject obj = e.getValue().getAsJsonObject();
//
//                EnumMap<ToolQuality, Integer> qMap = new EnumMap<>(ToolQuality.class);
//                if(obj.has("energy")) {
//                    JsonObject energy = obj.getAsJsonObject("energy");
//                    for (Map.Entry<String, JsonElement> en : energy.entrySet())
//                        qMap.put(ToolQuality.valueOf(en.getKey()), en.getValue().getAsInt());
//                }
//
//                EnumMap<FishingQuality, Integer> fMap = new EnumMap<>(FishingQuality.class);
//                if (obj.has("energyFishing")) {
//                    JsonObject energyF = obj.getAsJsonObject("energyFishing");
//                    for (Map.Entry<String, JsonElement> en : energyF.entrySet())
//                        fMap.put(FishingQuality.valueOf(en.getKey()), en.getValue().getAsInt());
//                }
//
//                EnumMap<ToolQuality, Integer> cMap = new EnumMap<>(ToolQuality.class);
//                if(obj.has("capacity")) {
//                    JsonObject capacity = obj.getAsJsonObject("capacity");
//                    for(Map.Entry<String, JsonElement> en : capacity.entrySet())
//                        cMap.put(ToolQuality.valueOf(en.getKey()), en.getValue().getAsInt());
//                }
//
//                TOOL_SPECS.put(name,
//                        new ToolSpec(name, qMap, fMap, cMap));
//            }
//        } catch (IOException ex){
//            throw new ExceptionInInitializerError("cannot load tool_specs.json" + ex);
//        }
//    }
//
//    public static ToolSpec getToolSpec(String name) {return TOOL_SPECS.get(name);}
//    public static Collection<ToolSpec> all() { return TOOL_SPECS.values(); }
//}