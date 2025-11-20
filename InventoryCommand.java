public class InventoryCommand implements CommandHandler{

    @Override
    public String execute(Command command, Player player) {
        return player.displayInventory();

    }
}
