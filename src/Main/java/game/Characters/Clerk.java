// Clerk.java
package game.Characters;  // Corrected package name to match directory structure

import game.Items.*;           // Correct import for Item
import game.Rooms.*;


public class Clerk extends NPC {





    public Clerk(Room startingRoom, Item desiredItem, Item rewardItems, Item rewardItems2, MemoryBlock memoryBlock) {
        super("Clerk", startingRoom, desiredItem, rewardItems, rewardItems2, memoryBlock);
    }








    @Override
    public void checkTrade(Player player) {

        if(containsTradeItem(getDesiredItem())) {
            initateTrade(getDesiredItem());
        }
        /*if (currentRoom.containsItems(desiredItem)) {
            currentRoom.removeItems(desiredItem.getName());
            inventory.add(desiredItem); }*/

        if(rewardItem != null) {
            player.addToInventory(rewardItem);
            player.addToInventory(getRewardItem2());


        }



        if(memoryBlock != null) {
            player.getJournal().addMemory(memoryBlock);
        }



            clearDialogue();
            addDialogue("'Ah… so this is what you meant to show me.'");
            addDialogue("She studies the photo carefully, nodding slowly.");
            addDialogue("'Thank you. This will help a lot.'");
            addDialogue("She reaches under the counter and hands you a small envelope.");
            addDialogue("'Take this — it might help jog your memory.'");

            dialogueReady = true;


            //System.out.println(getName());



    }
}


