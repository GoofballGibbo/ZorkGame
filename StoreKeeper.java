public class StoreKeeper extends NPC{

    public StoreKeeper(Room startingRoom, Item desiredItem, Item rewardItem, MemoryBlock memoryBlock){
        super("StoreKeeper", startingRoom, desiredItem, rewardItem, memoryBlock);
    }

    @Override
    public void checkTrade(Player player) {
        if (currentRoom.containsItems(desiredItem)) {
            currentRoom.removeItems(desiredItem.getName());
            inventory.add(desiredItem);

            if (rewardItem != null) {
                player.addToInventory(rewardItem);
            }

            if(memoryBlock != null) {
                player.getJournal().addMemory(memoryBlock);

            }

            dialogue.clear();
            addDialogue("The store keeper hands you the sandwich with a nod.");
            addDialogue("'Here you go. That should keep you going for a while.'");
            addDialogue("'Take care of yourself out there. Nights are long and memories are short.'");
            addDialogue("He watches you for a moment, then returns to his ledger.");


            sb.append(getName() + "\n");
            //System.out.println(getName());
            for (String line : dialogue) {
                sb.append(line + "\n");
                //System.out.println(line);
            }
        }
    }
}
