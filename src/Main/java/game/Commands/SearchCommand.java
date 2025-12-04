package game.Commands;

import game.Characters.*;
import game.CommandsInterface.*;


public class SearchCommand implements CommandHandler{

    @Override
    public String execute(Command command, Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.getCurrentRoom().printItems());
        return sb.toString();
    }
}
