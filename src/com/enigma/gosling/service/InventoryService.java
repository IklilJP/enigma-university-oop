package com.enigma.gosling.service;

import com.enigma.gosling.Book;

import java.util.List;


public interface InventoryService {

    void addBook(Book book);

    Book searchBookByTitle(String title);

    Book searchBookByCode(String code);

    void deleteBookByCode(String code);

    List<Book> getAllBooks();
}
