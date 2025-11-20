import java.util.ArrayList;

public class Clerk extends NPC {


    public Clerk(Room startingRoom, Item desiredItem, Item rewardItem) {
        super("Clerk", startingRoom, desiredItem, rewardItem);
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
            addDialogue("'Ah… so this is what you meant to show me.'");
            addDialogue("He studies the photo carefully, nodding slowly.");
            addDialogue("'Thank you. This will help a lot.'");
            addDialogue("He reaches under the counter and hands you a small envelope.");
            addDialogue("'Take this — it might help jog your memory.'");

            //System.out.println(getName());
            sb.append(getName());
            for (String line : dialogue) {
                //System.out.println(line);
                sb.append(line);
            }
        }
    }
}


