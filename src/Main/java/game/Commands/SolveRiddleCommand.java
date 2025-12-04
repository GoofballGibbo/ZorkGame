package game.Commands;

import game.Characters.Player;
import game.CommandsInterface.Command;
import game.CommandsInterface.CommandHandler;
import game.Rooms.Room;

public class SolveRiddleCommand implements CommandHandler {

    @Override
    public String execute(Command command, Player player) {
        String[] args = command.getArgs();
        if (args.length == 0) {
            return "You need to provide an answer. Usage: solve <answer>";
        }

        // Join all words as the answer
        String answer = String.join(" ", args);
        Room currentRoom = player.getCurrentRoom();

        if (currentRoom.getPuzzles().isEmpty()) {
            return "There are no puzzles to solve in this room.";
        }

        return currentRoom.solvePuzzle(answer, player);
    }
}
