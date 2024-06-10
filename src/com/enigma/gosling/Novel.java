package com.enigma.gosling;

public class Novel extends Book {
    private String publisher;
    private int yearPublished;
    private String author;

    public Novel(String code, String title, String publisher, int yearPublished, String author) {
        super(code, title);
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
