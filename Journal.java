import java.util.ArrayList;

public class Journal extends Item {
    private ArrayList<String> entries;
    private ArrayList<MemoryBlock> memoryEntry;


    public Journal() {
        super();
        entries = new ArrayList<>();
        memoryEntry = new ArrayList<>();
    }

    public void addEntry(String note) {
        entries.add(note);
    }

    public void addMemory(MemoryBlock memory) {
        for (MemoryBlock mem : memoryEntry) {
            if (mem.getDescription().equals(memory.getDescription())) {
                return; // memory already exists, do not add
            }
        }
        memoryEntry.add(memory); // add if not found
    }

    public void removeMemory(MemoryBlock memory) {
        memoryEntry.remove(memory);
    }

    public void removeEntry(String note) {
        entries.remove(note);
    }

    public String readMemoryEntry() {
        if(memoryEntry.isEmpty()) {
            return "Your journal is empty";
        }
        StringBuilder sb = new StringBuilder();
        for(MemoryBlock mem : memoryEntry) {
            sb.append("-").append(mem.getDescription()).append("\n");
        }
        return sb.toString();
    }

    public String readEntry() {
        if(entries.isEmpty()) {
            return "Your journal is empty";
        }
        StringBuilder sb = new StringBuilder();
        for(String entry : entries) {
            sb.append("-").append(entry).append("\n");
        }
        return sb.toString();
    }

    public boolean hasMemory(String keyword) {
        for (String entry : entries) {
            if(entry.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMemory(MemoryBlock memoryBlock) {
        if(memoryEntry.contains(memoryBlock)) {
            return true;
        }
        return false;
    }

    public boolean hasMemoryEntry(String keyword) {
        for (MemoryBlock mem : memoryEntry) {
            if(mem.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int memoryEntrySize() {
        return memoryEntry.size();

    }

}
