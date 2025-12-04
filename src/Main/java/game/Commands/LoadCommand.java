package game.Commands;
import game.Characters.*;
import game.CommandsInterface.*;
import game.Main.*;

public class LoadCommand implements CommandHandler {

    private final ZorkULGame game;

    /*private String fileName;
    private Map<String, Room> allRooms = new HashMap<>();*/

    public LoadCommand(ZorkULGame game) {
        this.game = game;
    }

    public String execute(Command command, Player player) {
        return game.loadGame();

        /*
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            allRooms = (HashMap<String, Room>) input.readObject();
            player = (Player) input.readObject();
            return "Game loaded successfully" + "\n" + player.getCurrentRoom().getLongDescription();

        } catch (IOException  | ClassNotFoundException i) {
            i.printStackTrace();
            return "Failed to load game";
        }*/



    }
}
