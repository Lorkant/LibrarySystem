package dao;

import model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<Integer, Book> books = new HashMap<>();
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void removeBook(Book book) {
        books.remove(book.getId());
    }

    public Book getBook(Integer id) {
        return books.get(id);
    }
}
