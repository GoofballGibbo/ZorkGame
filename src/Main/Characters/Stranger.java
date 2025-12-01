package Main.Characters;
import Main.Rooms.Room;
import Main.Items.*;


import java.util.ArrayList;
import java.util.List;

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
    public List<String> getDialogue() {
        List<String> dialogue = new ArrayList<>();
        switch (memoryLevel) {
            case NONE:
                dialogue.add("Ah… you stumble through the darkness of your own mind.");
                dialogue.add("No name, no past… just an empty shell. Delicious, isn’t it?");
                dialogue.add("Do you feel it? That hollow ache where your memories should be?");
                dialogue.add("I have taken them… and I watch as you flail blindly.");
                dialogue.add("Some pieces can be returned… for a price. But are you ready to pay it?");
                dialogue.add("The journey begins, though I wonder… will you survive the truth?");
                break;

            case PARTIAL:
                dialogue.add("Ah… fragments begin to flicker, like weak candlelight in a storm.");
                dialogue.add("You reach for them… but beware. Some memories are poisoned.");
                dialogue.add("The world you knew… it is not what it seems. Every truth has a shadow.");
                dialogue.add("Do you feel me watching, always watching, as you struggle?");
                dialogue.add("Each step you take is a step into my game… and I do enjoy watching.");
                dialogue.add("Keep searching, little lost one… but know that not all that returns is yours to hold.");
                break;

            case MOST:
                dialogue.add("Yes… yes, you remember more now. And yet, I see the fear creeping in.");
                dialogue.add("The pieces fit, but the picture… ah, the picture is darker than you imagine.");
                dialogue.add("Do you think you understand your own choices? How naive.");
                dialogue.add("Pain, regret… delight in the chaos, for it is mine to watch unfold.");
                dialogue.add("Remember the alley, the store… every moment shaped by shadows.");
                dialogue.add("You are close to knowing too much… and that is when the fun begins.");
                break;

            case COMPLETE:
                dialogue.add("Ah… magnificent. The whole picture, laid bare before your trembling eyes.");
                dialogue.add("Choices, losses, betrayals… you see now, don’t you? The weight of it all.");
                dialogue.add("Do you feel it? The truth… heavy, inescapable, and entirely mine to reveal.");
                dialogue.add("You thought this was your journey? No. It has always been mine to watch… to control.");
                dialogue.add("And now you understand… too late, perhaps, to change anything.");
                dialogue.add("Smile, if you can. This is the end… and yet, perhaps only a cruel beginning.");
                dialogue.add("Remember, little one… I am always watching. Always waiting.");
                break;
        }
        //List<String> strangerDialogue = getDialogue();
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
