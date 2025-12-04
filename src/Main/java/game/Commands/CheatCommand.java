package game.Commands;

import game.Characters.Player;
import game.CommandsInterface.*;
import game.Main.ZorkULGame;

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
