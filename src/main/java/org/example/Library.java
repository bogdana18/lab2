package org.example;

import java.util.ArrayList;
import java.util.List;

class Library {
    private final List<Item> items;
    private final List<Reader> readers;

    public Library() {
        items = new ArrayList<>();
        readers = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void registerReader(String name) {
        Reader reader = new Reader(name);
        readers.add(reader);
    }

    public void lendItem(Item item, Reader reader) {
        if (items.contains(item)) {
            reader.borrowItem(item);
            removeItem(item);
            System.out.println("Предмет видається " + reader + ": " + item);
        } else {
            System.out.println("Предмет не доступний для видачі.");
        }
    }

    public void returnItem(Item item, Reader reader) {
        if (reader.getBorrowedItems().contains(item)) {
            reader.returnItem(item);
            addItem(item);
            System.out.println("Предмет повертається: " + item);
        } else {
            System.out.println("Цей предмет не був виданий цьому читачеві.");
        }
    }

    public void displayAvailableItems() {
        System.out.println("Доступні предмети:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void displayBorrowedItems() {
        System.out.println("Предмети, що взяті у читачів:");
        for (Reader reader : readers) {
            List<Item> borrowedItems = reader.getBorrowedItems();
            for (Item item : borrowedItems) {
                System.out.println(reader + ": " + item);
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}
