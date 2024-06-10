package com.enigma.gosling;

import com.enigma.gosling.service.InventoryService;

import java.io.IOException;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private final List<Book> books;

    public InventoryServiceImpl() {
        try {
            this.books = IOFile.loadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
        try {
            IOFile.saveData(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book searchBookByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    @Override
    public Book searchBookByCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }

        for (Book book : books) {
            if (book.getCode().equalsIgnoreCase(code)) {
                return book;
            }
        }

        return null;
    }

    @Override
    public void deleteBookByCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        books.removeIf(book -> book.getCode().equalsIgnoreCase(code));
        try {
            IOFile.saveData(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getAllBooks(){
        return books;
    }
}
