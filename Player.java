import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Player extends Character {
    private HashMap<String, Item> inventory;
    private Room currentRoom;
    private boolean quit = false;

    public Player(String name, Room startingRoom) {
        super(name, startingRoom);
        this.currentRoom = startingRoom;
        inventory = new HashMap<>();
    }
    public void addToInventory(Item item) {
        inventory.put(item.getName().toLowerCase(), item);
    }

    public void addToInventory(Journal journal) {
        inventory.put("Journal", journal);
    }

    public void readJournal(Journal journal) {
        journal.readMemoryEntry();
    }
    public Item getItemFromInventory(String itemName) {
       return inventory.get(itemName.toLowerCase());
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

    public void removeFromInventory(Item item) {
        inventory.remove(item.getName().toLowerCase());
    }
    public Set<String> getInventoryKeys() {
        return inventory.keySet();
    }

    public Item convertItemStringtoItemObject(String itemName) {
        Item item = getItemFromInventory(itemName);
        return item;
    }

    public boolean hasItemInInventory(String item) {
        return inventory.containsKey(item);
    }


    public boolean hasQuit() { return quit; }
    public void setQuit(boolean quit) { this.quit = quit; }




}
