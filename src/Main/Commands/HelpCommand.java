package Main.Commands;

import Main.CommandsInterface.*;
import Main.Characters.*;
import Main.Main.*;
import com.sun.javafx.binding.BindingHelperObserver;




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