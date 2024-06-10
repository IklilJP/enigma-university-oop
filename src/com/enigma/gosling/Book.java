package com.enigma.gosling;

public abstract class Book {
    public String code;
    public String title;

    public Book(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public abstract String getCode();

    public abstract String getTitle();

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
