public class Vagrant extends NPC {

    public Vagrant(Room startingRoom, Item desiredItem, Item rewardItem) {
        super("Vagrant", startingRoom, desiredItem, rewardItem);
    }

    @Override
    public void checkTrade(Player player) {
        if (currentRoom.containsItems(desiredItem)) {
            currentRoom.removeItems(desiredItem.getName());
            inventory.add(desiredItem);

            if(rewardItem != null) {
                player.addToInventory(rewardItem);
            }

            dialogue.clear();
            addDialogue("'Ah, finally… thank you for this.'");
            addDialogue("'Here, take this. It might come in handy.'");
            addDialogue("'Don’t worry, I won’t forget your kindness.'");

            System.out.println(getName());
            for (String line : dialogue) {
                //System.out.println(line);
                sb.append(line);
            }
        }
    }
}

