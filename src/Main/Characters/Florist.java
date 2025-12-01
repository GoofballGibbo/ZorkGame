package Main.Characters;
import java.util.List;

import Main.Rooms.Room;
import Main.Items.*;


public class Florist extends NPC{

    private StringBuilder sb = new StringBuilder();

    public Florist(Room startingRoom, Item desiredItem, Item rewardItems, MemoryBlock memoryBlock) {
        super("Florist", startingRoom, desiredItem, rewardItems, memoryBlock);
    }

    @Override
    public void checkTrade(Player player) {

        if(containsTradeItem(getDesiredItem())) {
            initateTrade(getDesiredItem()); // Removes the item from the current room
        }
        if(rewardItem != null) {
            player.addToInventory(rewardItem);
        }

        if(memoryBlock != null) {
            player.getJournal().addMemory(memoryBlock);
        }

        clearDialogue();
        addDialogue("He slips the coins into a small wooden box, fingers lingering on the lid as if waiting for a memory to settle.");
        addDialogue("'That part always feels familiar… the exchange. Like it's stitched into me somehow.'");
        addDialogue("'Everything else drifts. Faces blur, voices tangle… but the flowers and the trade stay clear.'");
        addDialogue("His gaze drifts toward the shop window as though something outside might remind him of what he's lost.");
        addDialogue("'Someone used to laugh when the lilies arrived. Someone else cried over the violets. Those moments stay sharper than names ever do.'");
        addDialogue("He brushes a stray petal off the counter, pausing mid-motion as if a thought slips out of reach.");
        addDialogue("'I keep thinking I should remember more. Something important. Something right at the edge.'");
        addDialogue("His eyes narrow, studying the petals on the floor as if they might rearrange themselves into a memory.");
        addDialogue("'If the scent lingers long enough, maybe the memory will too.'");
        addDialogue("His voice softens, nearly a whisper.");
        addDialogue("'Come back… or don't. Either way, the flowers will keep the pieces safe.'");
        addDialogue(itemRecievedMessage(rewardItem));

        sb.append(getName());
        for (String line : getDialogue()) {
            //System.out.println(line);
            sb.append(line).append("\n");
        }

    }
}
