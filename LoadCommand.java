import java.io.*;
import java.util.HashMap;

public class LoadCommand implements CommandHandler {
    private String fileName;
    private HashMap<String, Room> allRooms = new HashMap<>();

    public LoadCommand(HashMap<String, Room> allRooms, String fileName) {
        this.allRooms = allRooms;
        this.fileName = fileName;
    }

    public String execute(Command command, Player player) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            allRooms = (HashMap<String, Room>) input.readObject();
            player = (Player) input.readObject();
            return "Game loaded successfully" + "\n" + player.getCurrentRoom().getLongDescription();

        } catch (IOException  | ClassNotFoundException i) {
            i.printStackTrace();
            return "Failed to load game";
        }



    }
}
