package org.example;


class Item {
    private String title;
    private String author;
    private String isbn;
    private int year;
    private String itemType;

    public Item(String title, String author, String isbn, int year, String itemType) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.itemType = itemType;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Тип: " + itemType + ", Назва: " + title + ", Автор: " + author + ", ISBN: " + isbn + ", Рік видання: " + year;
    }
}