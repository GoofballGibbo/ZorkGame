import java.io.Serializable;

public class MotelManager extends NPC {

    MotelManager(Room startingRoom, Item desiredItem) {
        super("Motel Manager", startingRoom, desiredItem, null);
    }

    @Override
    public void checkTrade(Player player) {
        if (currentRoom.containsItems(desiredItem)) {
            currentRoom.removeItems(desiredItem.getName());
            inventory.add(desiredItem);

            if (rewardItem != null) {
                player.addToInventory(rewardItem);
            }

            dialogue.clear();
            addDialogue("'Ah, I see you still have the key.'");
            addDialogue("'Good, this will let you access the motel safely.'");

            System.out.println(getName());
            for (String line : dialogue) {
                //System.out.println(line);
                sb.append(line);
            }
        }
    }
}
