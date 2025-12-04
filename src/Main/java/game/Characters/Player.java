package game.Characters;

import game.Main.ZorkULGame;
import game.Rooms.Room;


import game.Items.Inventory;
import game.Items.Item;
import game.Items.Journal;

public class Player extends Character {
    private Inventory<Item> inventory;  // Generic Inventory
    private boolean quit = false;
    private Journal journal;
    private ZorkULGame game;

    public Player(String name, Room startingRoom, Journal journal, ZorkULGame game) {
        super(name, startingRoom);
        this.currentRoom = startingRoom;
        this.inventory = new Inventory<>();
        this.journal = journal;
        this.game = game;
        addToInventory(journal);

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

    public ZorkULGame getGame() {
        return game;
    }


}




