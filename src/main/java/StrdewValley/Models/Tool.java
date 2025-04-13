package StrdewValley.Models;

import StrdewValley.Models.Enums.Quality;
import StrdewValley.Models.Enums.Tools;

public class Tool {
    private final Tools tool;
    private Quality toolQuality;

    public Tool(Tools tool) {
        this.tool = tool;
    }
}