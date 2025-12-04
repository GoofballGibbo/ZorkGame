package game.Items;

import java.io.Serializable;
import java.util.*;

public class Inventory<T> implements Serializable {
    private Map<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void add(String key, T item) {
        items.put(key.toLowerCase(), item);
    }

    public void remove(String key) {
        items.remove(key.toLowerCase());
    }

    public boolean containsKey(String key) {
        return items.containsKey(key.toLowerCase());
    }

    public boolean containsValue(T item) {
        return items.containsValue(item);
    }

    public T get(String key) {
        return items.get(key.toLowerCase());
    }

    public Collection<T> getAllItems() {
        return items.values();
    }

    public Set<String> getAllKeys() {
        return items.keySet();
    }

    public String displayInventory() {
        StringBuilder sb = new StringBuilder("You check your pocket to see:\n");
        for (String key : items.keySet()) {
            sb.append("- ").append(key).append("\n");
        }
        return sb.toString();
    }
}
