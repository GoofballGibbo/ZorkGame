package game.Commands;

import game.Characters.*;
import game.CommandsInterface.*;


public class InventoryCommand implements CommandHandler{

    @Override
    public String execute(Command command, Player player) {
        return player.displayInventory();

    }
}