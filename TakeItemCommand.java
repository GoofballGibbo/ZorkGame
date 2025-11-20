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
}
