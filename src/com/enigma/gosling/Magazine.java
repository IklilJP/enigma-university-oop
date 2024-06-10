package com.enigma.gosling;

public class Magazine extends Book {

    private String publicationPeriod;
    private int yearPublished;

    public Magazine(String code, String title, String publicationPeriod, int yearPublished) {
        super(code, title);
        this.publicationPeriod = publicationPeriod;
        this.yearPublished = yearPublished;
    }


    public String getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(String publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
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
