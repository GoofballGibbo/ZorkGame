package game.Characters;

import game.Rooms.Room;
import game.Items.*;


public class Vagrant extends NPC {

    private StringBuilder sb = new StringBuilder();

    public Vagrant(Room startingRoom, Item desiredItem, Item rewardItems, MemoryBlock memoryBlock) {
        super("Vagrant", startingRoom, desiredItem, rewardItems, memoryBlock);
    }

    @Override
    public void checkTrade(Player player) {
        if (currentRoom.containsItems(getDesiredItem())) {
            currentRoom.removeItems(getDesiredItem().getName());
            getInventory().add(getDesiredItem());

            if(rewardItem != null) {
                player.addToInventory(rewardItem);
            }

            if(memoryBlock != null) {
                player.getJournal().addMemory(memoryBlock);
            }

            clearDialogue();
            addDialogue("'Ah, finally… thank you for this.'");
            addDialogue("'Here, take this. It might come in handy.'");
            addDialogue("'Don’t worry, I won’t forget your kindness.'");
            addDialogue(itemRecievedMessage(rewardItem));

           dialogueReady = true;
        }
    }
}

