package Main.Commands;
import Main.Characters.*;
import Main.CommandsInterface.*;
import Main.Items.*;
import Main.Rooms.Room;


public class DropCommand implements CommandHandler {
    private String itemName;
    private NPC npc;



    @Override
    public String execute(Command command, Player player) {
        String[] args = command.getArgs();

        if (args == null || args.length == 0) {
            return "Drop what?\n";
        }

        // Join all args into one string and lowercase it
        String itemName = String.join(" ", args).trim().toLowerCase();

        if (player.hasItemInInventory(itemName)) {
            Item item = player.getItemFromInventory(itemName);
            player.removeFromInventory(item);
            player.getCurrentRoom().addItem(item);
            for (NPC npc : player.getCurrentRoom().getNPCs()) {
                npc.checkTrade(player);
            }
            return itemName + " has been dropped.\n";
        } else if(player.hasItemInInventory(player.getJournal()) ) {
            return "You can't drop the journal";

        }
        else {
            return "You don't have " + itemName + " in your inventory.\n";
        }

    }

     /*   String[] args = command.getArgs();
        StringBuilder sb = new StringBuilder();


        if(args.length == 0){
            //System.out.println("Drop what?: ");

            return ("Drop what?: \n");
        }


        String itemName = String.join(" ", args);


        if(player.hasItemInInventory(itemName)) {


            Item item = player.getItemFromInventory(itemName);
            player.removeFromInventory(item);

            sb.append(itemName);
            sb.append(" has been dropped.\n");
            //System.out.println(itemName + " has been dropped.\n");
            player.getCurrentRoom().addItem(item);

            for (NPC npc : player.getCurrentRoom().getNPCs()) {
                npc.checkTrade(player);
            }

        } else {
            sb.append("You don't have ").append(itemName).append(" in your inventory.\n");
        }
        return sb.toString();

    }*/
}
