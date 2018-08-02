package com.example.day9.bookCatalog;

public class Book {

  private String author;
  private String title;
  private int publishing_year;

  public Book(String author, String title, int publishing_year) {
    this.author = author;
    this.title = title;
    this.publishing_year = publishing_year;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public int getPublishing_year() {
    return publishing_year;
  }
}
