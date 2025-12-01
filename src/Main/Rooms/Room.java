package Main.Rooms;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Main.Items.*;
import Main.Characters.*;

public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private String description;
    private String name;
    private Item requiredItem;
    private Item rewardItem;
    private Map<String, Room> exits; // Map direction to neighboring Room
    private Map<String, Item> items;
    private ArrayList<NPC> NPCs;
    protected StringBuilder sb;






    public Room(String name, String description) {
        this.description = description;
        this.name = name;
        exits = new HashMap<>();
        items = new HashMap<>();
        NPCs = new ArrayList<>();
        sb = new StringBuilder();
    }

    public Room(String name, String description, Item requiredItem, Item rewardItem) {
        this.description = description;
        this.name = name;
        this.requiredItem = requiredItem;
        this.rewardItem = rewardItem;
        exits = new HashMap<>();
        items = new HashMap<>();
        NPCs = new ArrayList<>();
        sb = new StringBuilder();
    }

    public String getDescription() {
        return description;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public Item getRewardItem() {
        return rewardItem;
    }

    public String getName() {
        return name ;
    }



    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }



    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getExitString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Room> entry : exits.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue().getName()).append("\n");
        }
        return sb.toString().trim();
    }

    public String getLongDescription() {
        return description + ".\nExits: " + getExitString();
    }


    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    /* Example: Item apple = new Item("apple", "A red fruit")
     * room.addItem(apple)
     * */
    public void removeItems(String item) {items.remove(item);}

    public void removeItems(Item item) {items.remove(item);}
    public boolean containsItems(String item) {return items.containsKey(item);}

    public boolean containsItems(Item item) {return items.containsValue(item);}



    public String printItems() {
        if(items.isEmpty() || items.equals(null)) {
            sb.append("No items found.\n");
            //System.out.println("Looks like there's no items here");
        }
        else {
            //System.out.println("You found: ");
            sb.append("You found:\n");
            for (Map.Entry<String, Item> entry: items.entrySet()) {
                String itemName = entry.getKey();
                Item item = entry.getValue();
                //System.out.println("-" + itemName);
                sb.append("-").append(itemName).append("\n");
            }
        }
        return sb.toString();
    }

    public Item getItem(String itemName) {
        Item item = items.get(itemName);
        return item;
    }

    public void addNPC(NPC npc) {
        NPCs.add(npc);
    }
    public void removeNPC(NPC npc) {
        NPCs.remove(npc);
    }

    public boolean containsNPC(NPC npc) {
        return NPCs.contains(npc);
    }

    public ArrayList<NPC> getNPCs() {
        return NPCs;
    }

    public String interactNPC(Player player) {
        if(NPCs.isEmpty()){
            //System.out.println("No NPCs found");
            return("There's no one to interact with\n");
        }
        StringBuilder result = new StringBuilder();

        for (NPC npc : NPCs) {
            result.append(npc.interact(player)).append("\n");
        }
        return result.toString();
    }


    }









