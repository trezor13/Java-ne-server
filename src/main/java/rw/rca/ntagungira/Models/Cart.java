package rw.rca.ntagungira.Models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> items; // Product ID as key, quantity as value

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItem(String productId, int quantity) {
        items.put(productId, quantity);
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    // Other methods as needed
}
