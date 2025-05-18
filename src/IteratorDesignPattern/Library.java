package IteratorDesignPattern;

import java.util.List;

public class Library implements Aggregator{
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    @Override
    public Iterator getIterator() {
        return new BookIterator(books);
    }
}
