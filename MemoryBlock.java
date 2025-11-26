import java.io.Serializable;
import java.lang.management.MemoryPoolMXBean;

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

    public boolean isActive() {
        return active;
    }

    public void decay() {
        if (decayRate > 0) {
            decayRate--;
            if (decayRate == 0) {
                active = false;
            }
        }
    }

    public void refresh() {
        decayRate = 5;
        active = true;
    }
    public String getDescription() {
        return description;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void reveal() {
        this.revealed = true;
    }

    @Override
    public String toString() {
        return revealed ? description : "You feel like you had a memory here, but it’s hazy...";
    }

}
