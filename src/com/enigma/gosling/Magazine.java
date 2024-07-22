package com.enigma.gosling;

public class Magazine extends Book {

    private final String publicationPeriod;
    private final int yearPublished;

    public Magazine(String code, String title, String publicationPeriod, int yearPublished) {
        super(code, title);
        this.publicationPeriod = publicationPeriod;
        this.yearPublished = yearPublished;
    }


    public String getPublicationPeriod() {
        return publicationPeriod;
    }


    public int getYearPublished() {
        return yearPublished;
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
        return getCode() + "," + getTitle() + "," + getPublicationPeriod() + "," + getYearPublished();
    }
}
