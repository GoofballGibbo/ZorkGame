package Main.CommandsInterface;

import Main.Characters.*;


public interface CommandHandler {


    public String execute(Command command, Player player);
}