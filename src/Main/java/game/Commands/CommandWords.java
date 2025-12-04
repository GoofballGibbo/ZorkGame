package game.Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandWords {
    private Map<String, String> validCommands;
    protected StringBuilder sb;

    public CommandWords() {
        validCommands = new HashMap<>();
        validCommands.put("go", "Move to another room");
        validCommands.put("quit", "End the game");
        validCommands.put("help", "Show help");
        validCommands.put("look", "Look around");
        validCommands.put("eat", "Eat something");
        validCommands.put("take", "To take items and put them in player's inventory");
        validCommands.put("inventory", "Checks your inventory");
        validCommands.put("drop", "Drop an item");
        validCommands.put("inspect", "Inspect an item");
        validCommands.put("interact", "Interact with npcs");
        validCommands.put("search", "search for an item");
        validCommands.put("save", "save the game");
        validCommands.put("load", "load the game");
        validCommands.put("code", "Command to input pin code");
        validCommands.put("cheat", "Get to ending");
        validCommands.put("solve", "Solve puzzles");


        sb = new StringBuilder();

    }

    public boolean isCommand(String commandWord) {
        return validCommands.containsKey(commandWord);
    }

    public String showAll() {


        for (Map.Entry<String, String> entry : validCommands.entrySet()) {
            //System.out.print(command + " ");
            sb.append(entry.getKey())
                    .append(" : ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}