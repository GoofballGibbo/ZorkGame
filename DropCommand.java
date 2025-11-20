public class DropCommand implements CommandHandler {
    private String itemName;
    private NPC npc;



    @Override
    public String execute(Command command, Player player) {

        String[] args = command.getArgs();
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
}
