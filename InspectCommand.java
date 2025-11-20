public class InspectCommand implements CommandHandler {



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
