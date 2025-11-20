public class QuitCommand implements CommandHandler {

    @Override
    public String execute(Command command, Player player) {
        StringBuilder sb = new StringBuilder();
        //System.out.println("Thanks for playing!");
        sb.append("Thanks for playing!");
        player.setQuit(true);
        return sb.toString();
    }
}
