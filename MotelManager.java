import java.io.Serializable;

public class MotelManager extends NPC {

    private Room motelRoom;
    private Room startingRoom;

    MotelManager(Room startingRoom, Item desiredItem, Room motelRoom) {

        super("Motel Manager", startingRoom, desiredItem, null, null);
        this.startingRoom = startingRoom;
        this.motelRoom = motelRoom;
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
            player.setCurrentRoom(motelRoom);
            motelRoom.setExit("west", startingRoom);

            System.out.println(getName());
            for (String line : dialogue) {
                //System.out.println(line);
                sb.append(line);
            }
        }
    }
}
