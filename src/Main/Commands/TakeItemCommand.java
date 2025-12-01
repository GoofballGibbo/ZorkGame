package Main.Commands;

import Main.CommandsInterface.*;
import Main.Characters.*;
import Main.Items.*;
import Main.Rooms.*;

public class TakeItemCommand implements CommandHandler {
    private String itemName;
    private StringBuffer sb = new StringBuffer();

    @Override
    public String execute(Command command, Player player) {
        String[] args = command.getArgs();
        if(args.length == 0){
            sb.append("Take what?: \n");
            //System.out.println("Take what?: ");
        }
        String itemName = String.join(" ", args);

        if(player.getCurrentRoom().containsItems(itemName)) {
            Item item = player.getCurrentRoom().getItem(itemName);
            player.addToInventory(item);
            player.getCurrentRoom().removeItems(itemName);
            // sb.append(itemName);
            //sb.append(" has been taken.\n");
            sb.append(itemName + " has been taken" + "\n");
            //System.out.println(itemName + " has been taken.");
        }
        return sb.toString();
    }

    public static class InspectCommand implements CommandHandler {



        @Override
        public String execute(Command command, Player player) {
            StringBuilder sb = new StringBuilder();
            String[] args = command.getArgs();
            if(args.length == 0){
                //System.out.println("Inspect what?: ");
                sb.append("Inspect what?: \n");
            }
            String itemName = String.join(" ", args);
            if(player.hasItemInInventory(itemName)) {
                //System.out.println(player.getItemFromInventory(itemName).getDescription());
                sb.append(player.getItemFromInventory(itemName).getDescription());
            }
            return sb.toString();
        }
    }
}
