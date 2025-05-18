package IteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Great Gatsby"));
        books.add(new Book("To Kill a Mockingbird"));
        books.add(new Book("1984"));
        books.add(new Book("Pride and Prejudice"));
        books.add(new Book("The Catcher in the Rye"));

        Aggregator library = new Library(books);
        Iterator iterator = library.getIterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println("Book Name: " + book.getBookName());
        }
    }
}
