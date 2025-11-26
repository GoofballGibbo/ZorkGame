import java.util.ArrayList;

public class Stranger extends NPC{

    public Stranger(Room startingRoom) {
        super("Stranger", startingRoom, null, null, null);
    }


    public enum MemoryLevel {
        NONE, PARTIAL, MOST, COMPLETE
    }

    private MemoryLevel memoryLevel;

    @Override
    public String interact(Player player) {
        return "";
    }
    public void updateMemoryLevel(int memoryCount) {
        if (memoryCount == 0) {
            memoryLevel = MemoryLevel.NONE;
        } else if (memoryCount < 4) {
            memoryLevel = MemoryLevel.PARTIAL;
        } else if (memoryCount < 7) {
            memoryLevel = MemoryLevel.MOST;
        } else {
            memoryLevel = MemoryLevel.COMPLETE;
        }
    }



    @Override
    public ArrayList<String> getDialogue() {
        switch (memoryLevel) {
            case NONE:
                dialogue.add("You seem lost, friend. Do you even know who you are?");
                dialogue.add("I can tell you… the world has hidden pieces of your story.");
                break;
            case PARTIAL:
                dialogue.add("I can tell you… the world has hidden pieces of your story.");
                dialogue.add("Some truths are buried deep, and you’ll need to uncover them.");
                dialogue.add("Look around… the clues are there if you’re brave enough to see them.");
                break;
            case MOST:
                dialogue.add("Your memories are becoming clearer… you’re close to understanding it all.");
                dialogue.add("There’s danger in knowing too much, yet also freedom.");
                dialogue.add("Remember what happened in the alley… in the store… follow the path.");
                break;
            case COMPLETE:
                dialogue.add("Remember what happened in the alley… in the store… follow the path.");
                dialogue.add("Everything comes together now. You see the full picture.");
                dialogue.add("Choices, mistakes, losses… it all matters, and now you understand.");
                dialogue.add("Choices, mistakes, losses… it all matters, and now you understand.");
                dialogue.add("This is the end of your journey, and yet… perhaps the beginning of understanding.");
            default:
                return dialogue;
        }
        return dialogue;
    }
/*
    @Override
    public String interact(Player player) {
        StringBuilder sb = new StringBuilder();
        int memoryCount = player.getJournal().memoryEntrySize();
        if (memoryCount <= 2) {
            sb.append("The stranger watches you silently.\n");
            sb.append("'You barely remember anything. You need to explore more.'\n");
        } else if (memoryCount <= 5) {
            sb.append("The stranger nods knowingly.\n");
            sb.append("'You have glimpses of your past. Keep piecing it together.'\n");
        } else if (memoryCount <= 8) {
            sb.append("The stranger smiles faintly.\n");
            sb.append("'Almost there. Your memories are forming a clearer picture.'\n");
        } else { // Complete ending
            sb.append("The stranger steps into the light. It’s you — a reflection of yourself.\n");
            sb.append("'Through all your memories, you’ve found clarity and understanding.'\n");
        }

        return sb.toString();
    }*/




    @Override
    public void checkTrade(Player player) {

    }

}
