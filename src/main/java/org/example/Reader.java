package org.example;

import java.util.ArrayList;
import java.util.List;

class Reader {
    private String name;
    private List<Item> borrowedItems;

    public Reader(String name) {
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void borrowItem(Item item) {
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    @Override
    public String toString() {
        return "Читач: " + name;
    }
}

