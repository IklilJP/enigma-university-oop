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
    public void searchBookByTitle(String title) {
        boolean found = false;
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Buku ditemukan:");
                System.out.println("Kode: " + book.getCode());
                System.out.println("Judul: " + book.getTitle());

                if (book instanceof Novel novel) {
                    System.out.println("Penerbit: " + novel.getPublisher());
                    System.out.println("Tahun Terbit: " + novel.getYearPublished());
                    System.out.println("Penulis: " + novel.getAuthor());
                } else if (book instanceof Magazine magazine) {
                    System.out.println("Periode Terbit: " + magazine.getPublicationPeriod());
                    System.out.println("Tahun Terbit: " + magazine.getYearPublished());
                }

                found = true;
            }

        }
        if (!found) {
            System.out.println("Buku tidak ditemukan");
        }
    }

    @Override
    public void searchBookByCode(String code) {
        boolean found = false;
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }

        for (Book book : books) {
            if (book.getCode().equalsIgnoreCase(code)) {
                if (book instanceof Novel novel) {
                    System.out.println("Novel");
                    System.out.println("Kode: " + book.getCode());
                    System.out.println("Judul: " + novel.getTitle());
                    System.out.println("Penerbit: " + novel.getPublisher());
                    System.out.println("Tahun Terbit: " + novel.getYearPublished());
                    System.out.println("Penulis: " + novel.getAuthor());
                } else if (book instanceof Magazine magazine) {
                    System.out.println("Majalah");
                    System.out.println("Kode: " + book.getCode());
                    System.out.println("Judul: " + magazine.getTitle());
                    System.out.println("Periode Terbit: " + magazine.getPublicationPeriod());
                    System.out.println("Tahun Terbit: " + magazine.getYearPublished());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Buku tidak ditemukan");
        }
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
    public void getAllBooks() {
        for (Book book : books) {
            if (book instanceof Novel novel) {
                System.out.println("Novel");
                System.out.println("Kode: " + book.getCode());
                System.out.println("Judul: " + novel.getTitle());
                System.out.println("Penerbit: " + novel.getPublisher());
                System.out.println("Tahun Terbit: " + novel.getYearPublished());
                System.out.println("Penulis: " + novel.getAuthor());
            } else if (book instanceof Magazine magazine) {
                System.out.println("Majalah");
                System.out.println("Kode: " + book.getCode());
                System.out.println("Judul: " + magazine.getTitle());
                System.out.println("Periode Terbit: " + magazine.getPublicationPeriod());
                System.out.println("Tahun Terbit: " + magazine.getYearPublished());
            }
        }
    }
}
