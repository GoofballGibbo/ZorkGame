package game.CommandsInterface;

import game.Characters.*;


public interface CommandHandler {


    public String execute(Command command, Player player);
}