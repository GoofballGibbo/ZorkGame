package game.Commands;

import game.CommandsInterface.*;
import game.Main.*;
import game.Characters.*;




public class SaveCommand implements CommandHandler {
   /* private String fileName;
    private HashMap<String, Room> allRooms = new HashMap<>();*/

    private final ZorkULGame game;


    public SaveCommand(ZorkULGame game) {
        this.game = game;
    }
    public String execute(Command command, Player player) {
        return game.saveGame();

    }

        /*
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(allRooms);
            out.writeObject(player);
            return "Game saved successfully";

        } catch (Exception i) {
            i.printStackTrace();
            return "Failed to save game" + i;
        }
    }*/



}

