package Main.Characters;
import Main.Rooms.Room;
import Main.Items.*;
import Main.Items.MemoryBlock;

import java.io.Serializable;
import java.util.*;

public abstract class NPC extends Character  {
    private List<String> dialogue;
    private List<Item> inventory;
    protected Room room;
    private Item desiredItem;
    protected Item rewardItem;
    private  Item rewardItem2;
    protected MemoryBlock memoryBlock;


    public NPC(String name, Room startingRoom, Item desiredItem, Item rewardItem, MemoryBlock memoryBlock) {
        super(name, startingRoom);
        dialogue = new ArrayList<>();
        inventory = new ArrayList<>();
        this.desiredItem = desiredItem;
        this.rewardItem = rewardItem;
        this.memoryBlock = memoryBlock;
    }

    public NPC(String name, Room startingRoom, Item desiredItem, Item rewardItem, Item rewardItem2, MemoryBlock memoryBlock) {
        super(name, startingRoom);
        dialogue = new ArrayList<>();
        inventory = new ArrayList<>();
        this.desiredItem = desiredItem;
        this.rewardItem = rewardItem;
        this.rewardItem2 = rewardItem2;
        this.memoryBlock = memoryBlock;
    }

    public Item getRewardItem2() {
        return rewardItem2;
    }


    // ========================

    // Dialogue methods.

    public void addDialogue(String dialogues) {
        dialogue.add(dialogues);
    }
    public List<String> getDialogue() {
        return dialogue;
    }

    public void clearDialogue() {
        dialogue.clear();
    }





    // ========================

    // Item Trade Messages.

    public String itemRecievedMessage(Item rewardItem) {
       return "Received: " + rewardItem.getName();
    }

    public String itemRequirement(Item desiredItem) {
        return "Required: " + desiredItem.getName();
    }




    // =====================

    // Getter methods for constructor parameters.

    public String getName() {
        return name;
    }

    public Item getDesiredItem() {
        return desiredItem;
    }

    public Item getRewardItem() {
        return rewardItem;
    }

    public MemoryBlock getMemoryBlock() {
        return memoryBlock;
    }


    // ======================

    // Inventory methods

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }




    // =======================

    // NPC interaction methods

    public abstract void checkTrade(Player player);


    public String interact(Player player) {
        //System.out.println(getName());
        StringBuilder sb = new StringBuilder();
        for(String line : dialogue) {
            //System.out.println(line);
            sb.append(line).append("\n");
        }
        return sb.toString();
    }





    public boolean containsTradeItem(Item item) {
        if(currentRoom.containsItems(item)) {
            return true;
        }
        return false;
    }

    public void initateTrade(Item item) {
        currentRoom.removeItems(item.getName());
        inventory.add(item);
    }


   /* public void giveRewards(Player player) {
        for(Item item : rewardItems) {
            player.addToInventory(item);
        }

        //rewardItems.clear();
    }*/


}
