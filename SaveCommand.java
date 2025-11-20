import java.io.*;
import java.util.HashMap;


public class SaveCommand implements CommandHandler {
    private String fileName;
    private HashMap<String, Room> allRooms = new HashMap<>();


    public SaveCommand(HashMap<String, Room> allRooms, String fileName) {
        this.allRooms = allRooms;
        this.fileName = fileName;
    }
    public String execute(Command command, Player player) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(allRooms);
            out.writeObject(player);
            return "Game saved successfully";

        } catch (Exception i) {
            i.printStackTrace();
            return "Failed to save game" + i;
        }
    }
    }


