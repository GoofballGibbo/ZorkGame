package game.Characters;
import game.Rooms.Room;
import game.Items.*;
import game.Items.MemoryBlock;

import java.util.*;

public abstract class NPC extends Character  {
    private List<String> dialogue;
    private List<Item> inventory;
    protected Room room;
    private ArrayList<Item> rewardItems;
    private Item desiredItem;
    protected Item rewardItem;
    private  Item rewardItem2;
    protected MemoryBlock memoryBlock;
    protected StringBuilder dialogueBuilder = new StringBuilder();
    protected boolean dialogueReady = false;


    public NPC(String name, Room startingRoom, Item desiredItem, Item rewardItem, MemoryBlock memoryBlock) {
        super(name, startingRoom);
        dialogue = new ArrayList<>();
        inventory = new ArrayList<>();
        this.desiredItem = desiredItem;
        this.rewardItem = rewardItem;
        this.memoryBlock = memoryBlock;
    }

    /*public NPC(String name, Room startingRoom, Item desiredItem, ArrayList<Item> rewardItems, MemoryBlock memoryBlock) {
        super(name, startingRoom);
        this.dialogue = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.desiredItem = desiredItem;
        this.rewardItems =  new ArrayList<>();
        this.memoryBlock = memoryBlock;
    }*/

    public NPC(String name, Room startingRoom, Item desiredItem, Item rewardItem, Item rewardItem2, MemoryBlock memoryBlock) {
        super(name, startingRoom);
        dialogue = new ArrayList<>();
        inventory = new ArrayList<>();
        this.desiredItem = desiredItem;
        this.rewardItem = rewardItem;
        this.rewardItem2 = rewardItem2;
        this.memoryBlock = memoryBlock;
    }

    public NPC() {

    }

    public Item getRewardItem2() {
        return rewardItem2;
    }


    public void addRewardItem(Item item) {
        if (item != null) {
            rewardItems.add(item);
        }
    }

    public ArrayList<Item> getRewardItems() {
        return new ArrayList<>(rewardItems);
    }

    // ========================

    // Dialogue methods.

    public void addDialogue(String dialogues) {
        dialogue.add(dialogues);
        dialogueBuilder.append(dialogues).append("\n");

    }
    public List<String> getDialogue() {
        return dialogue;
    }

    public void clearDialogue() {
        dialogue.clear();
        dialogueBuilder.setLength(0);
    }



    public boolean isDialogueReady() {
        return dialogueReady;
    }

    public void clearDialogueReady() {
        dialogueReady = false;
    }

    public String getFullDialogue() {
        return dialogueBuilder.toString();
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
