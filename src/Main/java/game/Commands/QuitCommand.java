package game.Commands;

import game.CommandsInterface.*;
import game.Characters.*;


public class QuitCommand implements CommandHandler {

    @Override
    public String execute(Command command, Player player) {
        System.exit(0);
        StringBuilder sb = new StringBuilder();
        //System.out.println("Thanks for playing!");
        sb.append("Thanks for playing!");
        player.setQuit(true);
        return sb.toString();
    }
}