package com.enigma.gosling;

public class Novel extends Book {
    private final String publisher;
    private final int yearPublished;
    private final String author;

    public Novel(String code, String title, String publisher, int yearPublished, String author) {
        super(code, title);
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getAuthor() {
        return author;
    }



    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getCode() + "," + getTitle() + "," + getPublisher() + "," + getYearPublished() + "," + getAuthor();
    }
}
