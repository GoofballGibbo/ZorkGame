import java.util.Map;

public class CodeCommand implements CommandHandler {

    private String code;
    private Map<String, Room> allRooms;


    public CodeCommand(String code, Map<String, Room> allRooms) {
        this.code = code;
        this.allRooms = allRooms;
    }

    @Override
    public String execute(Command command, Player player) {
        String input = null;

        if (command.hasSecondWord()) {
            input = command.getSecondWord();
        } else if (command.hasArgs()) {
            input = command.getArg(0);
        } else {
            input = command.getCommandWord();
        }

        if (input == null) {
            return "You must type a code. Example: 'code 4815'";

        }

        if (input.equals(code)) {
            Room warehouse = allRooms.get("Warehouse");
            player.setCurrentRoom(warehouse);
            return "The code is correct! You enter the Warehouse.\n" + player.getCurrentRoom().getLongDescription();
        } else {
            return "Incorrect code. Try again.";
        }
    }
}