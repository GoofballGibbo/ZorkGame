package Main.Commands;
import java.util.ArrayList;

import Main.CommandsInterface.*;
import Main.Characters.*;
import Main.Rooms.*;


public class InteractCommand implements CommandHandler{
    private Player player;
    private Room room;
    private NPC npc;

    @Override
    public String execute(Command command, Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.getCurrentRoom().interactNPC(player));



        if(player.getCurrentRoom().getName().toLowerCase().equalsIgnoreCase("pin")) {

            sb.append(player.getCurrentRoom().getLongDescription());


        }


        return sb.toString();



    }
}
