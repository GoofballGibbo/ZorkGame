import java.io.Serializable;
import java.util.ArrayList;

public abstract class NPC extends Character  {
    protected ArrayList<String> dialogue;
    protected ArrayList<Item> inventory;
    protected Room room;
    protected Item desiredItem;
    protected Item rewardItem;
    protected StringBuilder sb;

    public NPC(String name, Room startingRoom, Item desiredItem, Item rewardItem) {
        super(name, startingRoom);
        dialogue = new ArrayList<>();
        inventory = new ArrayList<>();
        sb = new StringBuilder();
        this.desiredItem = desiredItem;
        this.rewardItem = rewardItem;
    }

    public NPC(String name, Room startingRoom) {
        super(name, startingRoom);
        dialogue = new ArrayList<>();
        inventory = new ArrayList<>();
    }

    // Implemented method
    public void addDialogue(String dialogues) {
        dialogue.add(dialogues);
    }

    public String getName() {
        return name;
    }

    public void clearDialogue() {
        dialogue.clear();
    }

    public ArrayList<String> getDialogue() {
        return dialogue;
    }

    public String interact(Player player) {
        //System.out.println(getName());
        StringBuilder sb = new StringBuilder();
        for(String line : dialogue) {
            //System.out.println(line);
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public abstract void checkTrade(Player player);

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }


}
