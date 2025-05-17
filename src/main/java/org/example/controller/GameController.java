package org.example.controller;

import org.example.model.Result;
import org.example.model.characters.Player;
import org.example.model.context.App;
import org.example.model.context.Game;
import org.example.model.items.Item;
import org.example.model.items.tools.Tool;
import org.example.model.world.time.Season;
import org.example.model.world.time.WeatherType;

public class GameController {
    public Result next(){
        Game game = App.getCurrentGame();
        game.nextTurn();
        return new Result(true, "Turn of: "+game.getCurrentPlayer().getUsername());
    }
    public Result time(){
        Game game = App.getCurrentGame();
        int t = game.getTime().getHourOfDay();
        return new Result(true, "Time: "+t);
    }
    public Result date(){
        Game game = App.getCurrentGame();
        int d = game.getTime().getDayIndex();
        String s = game.getTime().getSeason().getName();
        return new Result(true, "Date: "+d+"/"+s);
    }
    public Result datetime(){
        return new Result(true, time().toString() + " " + date().toString());
    }
    public Result dayWeek(){
        Game game = App.getCurrentGame();
        int d = game.getTime().getDayOfWeek();
        return new Result(true, "Day: "+d);
    }
    public Result cheatTime(int h){
        Game game = App.getCurrentGame();
        game.getTime().advanceHours(h);
        return new Result(true, "Time: " + game.getTime().getHourOfDay());
    }
    public Result cheatDate(int d){
        Game game = App.getCurrentGame();
        game.getTime().advanceDays(d);
        return new Result(true, "Day: " + game.getTime().getDayOfWeek());
    }
    public Result season(){
        Game game = App.getCurrentGame();
        String s = game.getTime().getSeason().getName();
        return new Result(true, "Season: "+s);
    }
    public Result cheatThor(int x, int y){
        Game game = App.getCurrentGame();
        if(game.getSeason().getToday() != WeatherType.STORM)
            return new Result(false, "Today is not a stormy day.");
        game.getSeason().thor(x,y);
        return new Result(true, "Booom..!");
    }
    public Result weather(){
        Game game = App.getCurrentGame();
        WeatherType type = game.getSeason().getToday();
        return new Result(true, "Today weather: "+type.name());
    }
    public Result weatherForecast(){
        WeatherType type = Season.predictWeather();
        return new Result(true, "Predicted tomorrow weather: "+type.name());
    }
    public Result cheatWeather(String weather){
        WeatherType type = WeatherType.getWeatherOfName(weather);
        if(type == null){
            return new Result(false, "Unknown weather type: "+weather);
        }
        Game game = App.getCurrentGame();
        game.getSeason().setTomorrow(type);
        return new Result(true, "Tomorrow weather: "+type.name());
    }
    public Result greenHouseBuild(){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();
        if(!p.buildGreen(game))
            return new Result(false, "Can't build green house.");
        return new Result(true, "Build green house.");
    }
    public Result walk(int x, int y){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();
        game.getMap().walkScored(p,x,y);
        return new Result(true, game.getMap().printMapColored(p,3));
    }
    public Result showEnergy(){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();
        return new Result(true, "Your energy is:" + p.getCurrentEnergy());
    }
    public Result cheatEnergySet(int energy){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();
        p.setCurrentEnergy(energy);

        return new Result(true, "Your energy is:" + p.getCurrentEnergy());
    }
    public Result cheatEnergy(){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();
        p.setCurrentEnergy(1_000_000);
        p.setTurnEnergy(1_000_000);

        return new Result(true, "Your energy is:" + p.getCurrentEnergy());
    }
    public Result inventoryShow(){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();

        System.out.println("─── Inventory ───");
        for (var entry : p.inventory().getItems().entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            System.out.printf("\n%-25s  × %d%n", item.getName(), quantity);
        }
        return new Result(true, "This is you inventory.");
    }
    public Result inventoryTrash(String name, int number){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();

        p.inventory().deleteItem(name, number, game, p);
        return new Result(true, name + " has been trashed.");
    }
    public Result inventoryTrash(String name){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();

        p.inventory().deleteItem(name, game, p);
        return new Result(true, name + " has been trashed.");
    }
    public Result equipTool(String name){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();

        Tool tool = (Tool) p.inventory().getItem(name);
        if (tool == null)
            return new Result(false, "Tool not found.");

        p.inventory().setCurrentTool(tool);
        return new Result(true, "Tool equipped.");
    }
    public Result showTools(){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();

        p.inventory().allTools();
        return new Result(true, "This is your tools.");
    }
    public Result useTool(String dir){
        Game game = App.getCurrentGame();
        Player p = game.getCurrentPlayer();

        p.inventory().getCurrentTool().getAction().use(this,);
    }
}