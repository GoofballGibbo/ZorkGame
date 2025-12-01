package Main.Commands;

import Main.Characters.*;
import Main.CommandsInterface.*;


public class InventoryCommand implements CommandHandler{

    @Override
    public String execute(Command command, Player player) {
        return player.displayInventory();

    }
}