package com.enigma.gosling.service;

import com.enigma.gosling.Book;

import java.util.List;


public interface InventoryService {

    void addBook(Book book);

    void searchBookByTitle(String title);

    void searchBookByCode(String code);

    void deleteBookByCode(String code);

    void getAllBooks();
}
