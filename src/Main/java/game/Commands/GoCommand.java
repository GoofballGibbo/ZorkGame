package game.Commands;

import game.Characters.*;
import game.CommandsInterface.*;
import game.Rooms.*;
import game.Main.*;

public class GoCommand implements CommandHandler{

    private String direction;
    private ZorkULGame game;

    @Override
    public String execute(Command command, Player player) {
        StringBuilder sb = new StringBuilder();
        String[] args = command.getArgs();
        if(args.length == 0){
            //System.out.println("Go where?: ");
            return("Go where?: \n");
        }

        direction = args[0].toLowerCase().trim();

        Room nextRoom = player.getCurrentRoom().getExit(direction);
        if(nextRoom == null){
            //System.out.println("You can't go that way.");
            return("You can't go that way");
        }


        player.setCurrentRoom(nextRoom);
        sb.append(player.getCurrentRoom().getLongDescription());

        //System.out.println(player.getCurrentRoom().getLongDescription());
        return sb.toString();
    }
}
