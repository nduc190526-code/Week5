package Bai5bonus;
import java.util.*;

class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Title: " + title
                + ", Author: " + author
                + ", Year: " + year;
    }
}




class LibraryManagement {
    private ArrayList<Book> list = new ArrayList<>();
    private HashMap<String, Book> hashMap = new HashMap<>();
    private TreeMap<String, Book> treeMap = new TreeMap<>();

    public void addBook(Book book) {
        if (hashMap.containsKey(book.getId())) {
            System.out.println("Book ID already exists!");
            return;
        }

        list.add(book);
        hashMap.put(book.getId(), book);
        treeMap.put(book.getId(), book);

        System.out.println("Book added successfully!");
    }

    public Book findInList(String id) {
        for (Book book : list) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }

    public Book findInHashMap(String id) {
        return hashMap.get(id);
    }

    public Book findInTreeMap(String id) {
        return treeMap.get(id);
    }

    public void deleteBook(String id) {
        boolean found = hashMap.containsKey(id);

        if (!found) {
            System.out.println("Book not found!");
            return;
        }

        list.removeIf(book -> book.getId().equals(id));
        hashMap.remove(id);
        treeMap.remove(id);

        System.out.println("Book deleted successfully!");
    }

    public void displayList() {
        System.out.println("\n===== ARRAYLIST =====");

        for (Book book : list) {
            System.out.println(book);
        }
    }

    public void displayHashMap() {
        System.out.println("\n===== HASHMAP =====");

        for (Book book : hashMap.values()) {
            System.out.println(book);
        }
    }

    public void displayTreeMap() {
        System.out.println("\n===== TREEMAP =====");

        for (Book book : treeMap.values()) {
            System.out.println(book);
        }
    }
}


public class main {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addBook(new Book("B03", "Java Basic", "Nam", 2020));
        library.addBook(new Book("B01", "C Programming", "An", 2019));
        library.addBook(new Book("B05", "Python", "Minh", 2022));
        library.addBook(new Book("B02", "Data Structures", "Lan", 2021));
        library.addBook(new Book("B04", "Algorithms", "Hung", 2023));

        System.out.println("\n===== SEARCH BOOK =====");

        System.out.println("\nSearch in ArrayList:");
        System.out.println(library.findInList("B03"));

        System.out.println("\nSearch in HashMap:");
        System.out.println(library.findInHashMap("B03"));

        System.out.println("\nSearch in TreeMap:");
        System.out.println(library.findInTreeMap("B03"));

        System.out.println("\n===== DELETE BOOK =====");

        library.deleteBook("B03");

        System.out.println("\n===== DISPLAY BOOKS =====");

        library.displayList();

        library.displayHashMap();

        library.displayTreeMap();
    }
}
