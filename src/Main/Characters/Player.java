package Main.Characters;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Main.Main.ZorkULGame;
import Main.Rooms.Room;
import Main.Items.*;




/*
public class Player extends Character {
    private Map<String, Item> inventory;
    private Room currentRoom;
    private boolean quit = false;
    private Journal journal;

    public Player(String name, Room startingRoom) {
        super(name, startingRoom);
        this.currentRoom = startingRoom;
        inventory = new HashMap<>();
        this.journal = new Journal();
    }
    public void addToInventory(Item item) {
        inventory.put(item.getName().toLowerCase(), item);
    }

    public Journal getJournal() {
        return journal;
    }

    public void addToInventory(Journal journal) {
        this.journal = journal;
        inventory.put("Journal", journal);
    }

    public void readJournal(Journal journal) {
        journal.readMemoryEntry();
    }






    public String displayInventory() {
        //System.out.print("You check your pocket to see: \n");
        StringBuilder sb = new StringBuilder();
        sb.append("You check your pocket to see: \n");
        for(Map.Entry<String, Item> entry : inventory.entrySet()) {
            //System.out.println(entry.getKey());
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }




    public boolean inventoryContainsItemKey(Item item) {
        System.out.println(item.getName());
        return inventory.containsKey(item.getName());
    }




    public boolean hasItemInInventory(Item item) {
        return inventory.containsValue(item);
    }


    public Map<String, Item> getInventory() {
        return inventory;
    }


    public boolean hasQuit() { return quit; }
    public void setQuit(boolean quit) { this.quit = quit; }

    public Item getItemFromInventory(String itemName) {
        if (itemName == null) return null;
        return inventory.get(itemName.toLowerCase().trim());
    }

    public boolean hasItemInInventory(String itemName) {
        if (itemName == null) return false;
        return inventory.containsKey(itemName.toLowerCase().trim());
    }

    public void removeFromInventory(Item item) {
        if (item != null) {
            inventory.remove(item.getName().toLowerCase().trim());
        }
    }*/





import Main.Items.Inventory;
import Main.Items.Item;
import Main.Items.Journal;
import Main.Rooms.Room;
import java.io.Serializable;

public class Player extends Character implements Serializable {
    private Inventory<Item> inventory;  // Generic Inventory
    private Room currentRoom;
    private boolean quit = false;
    private Journal journal;

    public Player(String name, Room startingRoom, Journal journal) {
        super(name, startingRoom);
        this.currentRoom = startingRoom;
        this.inventory = new Inventory<>();
        this.journal = journal;
          // Add Journal to inventory
    }

    // Add item to inventory
    public void addToInventory(Item item) {
        if (item != null) inventory.add(item.getName(), item);
    }

    // Remove item
    public void removeFromInventory(Item item) {
        if (item != null) inventory.remove(item.getName());
    }

    // Check inventory
    public boolean hasItemInInventory(String itemName) {
        return inventory.containsKey(itemName);
    }

    public boolean hasItemInInventory(Item item) {
        return inventory.containsValue(item);
    }

    // Retrieve item
    public Item getItemFromInventory(String itemName) {
        return inventory.get(itemName);
    }

    // Display inventory
    public String displayInventory() {
        return inventory.displayInventory();
    }

    public Inventory<Item> getInventory() {
        return inventory;
    }

    public Journal getJournal() {
        return journal;
    }

    public void readJournal() {
        journal.readMemoryEntry();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public boolean hasQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }


}




