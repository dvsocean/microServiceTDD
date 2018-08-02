package com.example.withFelssey.bookCatalog;

public class Book {

  private String title;
  private String author;
  private int publishingYear;

  public void setPublishingYear(int publishingYear) {
    this.publishingYear = publishingYear;
  }

  public Book(String title, String author, int publishingYear) {
    this.title = title;
    this.author = author;
    this.publishingYear = publishingYear;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPublishingYear() {
    return publishingYear;
  }
}
