import java.io.Serializable;
import java.lang.management.MemoryPoolMXBean;

public class MemoryBlock implements Serializable {
    private String description;
    private boolean revealed;

    public MemoryBlock(String description) {
        this.description = description;
        this.revealed = false;
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
