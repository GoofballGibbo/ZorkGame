package Main.Commands;

import Main.Characters.Player;
import Main.CommandsInterface.*;
import Main.Commands.*;
import Main.Main.ZorkULGame;

public class CheatCommand implements CommandHandler {

    private ZorkULGame game;

    public CheatCommand(ZorkULGame game) {
        this.game = game;
    }

    public String execute(Command command, Player player) {
        game.cheat();
        return "Cheat enabled";
    }
}
