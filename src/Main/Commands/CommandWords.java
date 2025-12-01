package Main.Commands;

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

        sb = new StringBuilder();

    }

    public boolean isCommand(String commandWord) {
        System.out.println("CHECKING COMMAND: " + commandWord);
        System.out.println("CURRENT COMMAND LIST: " + validCommands.keySet());
        return validCommands.containsKey(commandWord);
    }

    public String showAll() {

        System.out.print("Valid commands are: ");
        sb.append("Valid commands are: ");
        for (String command : validCommands.keySet()) {
            //System.out.print(command + " ");
            sb.append(command + "\n");
        }
        return sb.toString();
    }
}