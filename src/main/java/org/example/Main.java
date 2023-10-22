package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Додати новий предмет (книгу або DVD) в бібліотеку");
            System.out.println("2. Видалити предмет з бібліотеки");
            System.out.println("3. Реєстрація читача");
            System.out.println("4. Видача предмета читачеві");
            System.out.println("5. Повернення предмета у бібліотеку");
            System.out.println("6. Показати список доступних предметів");
            System.out.println("7. Показати список взятих предметів");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Додавання нового предмета
                    System.out.println("Введіть тип предмета (книга або DVD), назву, автора, ISBN та рік видання:");
                    String itemType = scanner.next();
                    String title = scanner.next();
                    String author = scanner.next();
                    String isbn = scanner.next();
                    int year = scanner.nextInt();
                    library.addItem(new Item(title, author, isbn, year, itemType));
                    break;
                case 2:
                    // Видалення предмета з бібліотеки
                    System.out.println("Введіть ISBN предмета для видалення:");
                    String isbnToRemove = scanner.next();
                    Item itemToRemove = null;
                    for (Item item : library.getItems()) {
                        if (item.getIsbn().equals(isbnToRemove)) {
                            itemToRemove = item;
                            break;
                        }
                    }
                    if (itemToRemove != null) {
                        library.removeItem(itemToRemove);
                        System.out.println("Предмет був видалений з бібліотеки.");
                    } else {
                        System.out.println("Предмет з ISBN " + isbnToRemove + " не знайдений.");
                    }
                    break;
                case 3:
                    // Реєстрація читача
                    System.out.println("Введіть ім'я читача:");
                    String readerName = scanner.next();
                    library.registerReader(readerName);
                    System.out.println("Читача " + readerName + " зареєстровано.");
                    break;
                case 4:
                    System.out.println("Введіть ім'я читача:");
                    String readerToLendName = scanner.next();
                    Reader readerToLend = null;
                    for (Reader reader : library.getReaders()) {
                        if (readerToLendName.equals(reader.getName())) {
                            readerToLend = reader;
                            break;
                        }
                    }
                    if (readerToLend != null) {
                        library.displayAvailableItems();
                        System.out.println("Введіть ISBN предмета для видачі:");
                        String isbnToLend = scanner.next();
                        Item itemToLend = null;
                        for (Item item : library.getItems()) {
                            if (isbnToLend.equals(item.getIsbn())) {
                                itemToLend = item;
                                break;
                            }
                        }
                        if (itemToLend != null) {
                            library.lendItem(itemToLend, readerToLend);
                        } else {
                            System.out.println("Предмет з ISBN " + isbnToLend + " не знайдений.");
                        }
                    } else {
                        System.out.println("Читача з ім'ям " + readerToLendName + " не зареєстровано.");
                    }
                    break;
                case 5:
                    // Повернення предмета у бібліотеку
                    System.out.println("Введіть ім'я читача:");
                    String readerToReturnName = scanner.next();
                    Reader readerToReturn = null;
                    for (Reader reader : library.getReaders()) {
                        if (readerToReturnName.equals(reader.getName())) {
                            readerToReturn = reader;
                            break;
                        }
                    }
                    if (readerToReturn != null) {
                        List<Item> borrowedItems = readerToReturn.getBorrowedItems();
                        if (!borrowedItems.isEmpty()) {
                            System.out.println("Предмети, що взяті цим читачем:");
                            for (int i = 0; i < borrowedItems.size(); i++) {
                                System.out.println(i + ". " + borrowedItems.get(i));
                            }
                            System.out.println("Введіть номер предмета для повернення:");
                            int itemIndexToReturn = scanner.nextInt();
                            if (itemIndexToReturn >= 0 && itemIndexToReturn < borrowedItems.size()) {
                                Item itemToReturn = borrowedItems.get(itemIndexToReturn);
                                library.returnItem(itemToReturn, readerToReturn);
                            } else {
                                System.out.println("Неправильний номер предмета.");
                            }
                        } else {
                            System.out.println("Цей читач не має взятих предметів.");
                        }
                    } else {
                        System.out.println("Читача з ім'ям " + readerToReturnName + " не зареєстровано.");
                    }
                    break;
                case 6:
                    // Показати список доступних предметів
                    library.displayAvailableItems();
                    break;
                case 7:
                    // Показати список взятих предметів та їхніх читачів
                    library.displayBorrowedItems();
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }
}