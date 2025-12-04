package game.Commands;

import game.CommandsInterface.*;
import game.Characters.*;
import game.Main.*;


public class HelpCommand implements CommandHandler {

    private ZorkULGame game;


    public HelpCommand(ZorkULGame game) {
        this.game = game;
    }



    @Override
    public String execute(Command command, Player player) {
        return game.printHelp();
    }
}