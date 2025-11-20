import java.util.ArrayList;

public class InteractCommand implements CommandHandler{
    private Player player;
    private Room room;
    private NPC npc;

    @Override
    public String execute(Command command, Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.getCurrentRoom().interactNPC(player));

        return sb.toString();



    }
}
