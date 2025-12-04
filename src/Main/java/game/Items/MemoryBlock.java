package game.Items;
import java.io.Serializable;

public class MemoryBlock implements Serializable {
    private String description;
    private boolean revealed;
    private int decayRate;
    private boolean active;

    public MemoryBlock(String description) {
        this.description = description;
    }

    public MemoryBlock(String description, int decayRate) {
        this.description = description;
        this.decayRate = decayRate;
        this.active = true;
    }



    public void refresh() {
        decayRate = 5;
        active = true;
    }
    public String getDescription() {
        return description;
    }



    @Override
    public String toString() {
        return revealed ? description : "You feel like you had a memory here, but it’s hazy...";
    }

}
