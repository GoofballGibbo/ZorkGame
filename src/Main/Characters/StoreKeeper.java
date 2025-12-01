package Main.Characters;

import Main.Rooms.Room;
import Main.Items.*;


public class StoreKeeper extends NPC{

    private StringBuilder sb = new StringBuilder();

    public StoreKeeper(Room startingRoom, Item desiredItem, Item rewardItem, MemoryBlock memoryBlock){
        super("StoreKeeper", startingRoom, desiredItem, rewardItem, memoryBlock);
    }

    @Override
    public void checkTrade(Player player) {
        if (currentRoom.containsItems(getDesiredItem())) {
            currentRoom.removeItems(getDesiredItem().getName());
            getInventory().add(getDesiredItem());

            if (rewardItem != null) {
                player.addToInventory(rewardItem);
            }

            if(memoryBlock != null) {
                player.getJournal().addMemory(memoryBlock);

            }

            clearDialogue();
            addDialogue("The store keeper hands you the sandwich with a nod.");
            addDialogue("'Here you go. That should keep you going for a while.'");
            addDialogue("'Take care of yourself out there. Nights are long and memories are short.'");
            addDialogue("He watches you for a moment, then returns to his ledger.");
            addDialogue(itemRecievedMessage(rewardItem));


            sb.append(getName()).append("\n");
            //System.out.println(getName());
            for (String line : getDialogue()) {
                sb.append(line).append("\n");
                //System.out.println(line);
            }
        }
    }
}
