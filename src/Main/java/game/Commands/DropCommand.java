package game.Commands;
import game.Characters.*;
import game.CommandsInterface.*;
import game.Items.*;


public class DropCommand implements CommandHandler {

    @Override
    public String execute(Command command, Player player) {
        String[] args = command.getArgs();

        if (args == null || args.length == 0) {
            return "Drop what?\n";
        }

        String itemName = String.join(" ", args).trim().toLowerCase();
        Item item = player.getItemFromInventory(itemName);

        if (item instanceof Journal) {
            return "You can't drop the journal.\n";
        }

        if (!player.hasItemInInventory(itemName)) {
            return "You don't have " + itemName + " in your inventory.\n";
        }

        // Drop the item
        player.removeFromInventory(item);
        player.getCurrentRoom().addItem(item);

        StringBuilder output = new StringBuilder();
        output.append(itemName).append(" has been dropped.\n");

        // Check trades for all NPCs
        for (NPC npc : player.getCurrentRoom().getNPCs()) {
            npc.checkTrade(player);

            // If this NPC generated dialogue, append it
            if (npc.isDialogueReady()) {
                output.append(npc.getFullDialogue()).append("\n");
                npc.clearDialogueReady();
            }
        }

        return output.toString();
    }

}



/*
    @Override
    public String execute(Command command, Player player) {
        String[] args = command.getArgs();

        if (args == null || args.length == 0) {
            return "Drop what?\n";
        }

        // Join all args into one string and lowercase it
        String itemName = String.join(" ", args).trim().toLowerCase();
        Item item = player.getItemFromInventory(itemName);
        if(item instanceof Journal) {
            return "You can't drop the journal";

        }
         if (player.hasItemInInventory(itemName)) {
            player.removeFromInventory(item);
            player.getCurrentRoom().addItem(item);
            for (NPC npc : player.getCurrentRoom().getNPCs()) {
                npc.checkTrade(player);
            }
            return itemName + " has been dropped.\n";
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

    }
}*/
