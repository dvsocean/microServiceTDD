package com.example.withFelssey.bookCatalog;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {

  private List<Book> catalog = new ArrayList<Book>();

  public void addBook(Book book){
    catalog.add(book);
  }

  public List<Book> findByTitle(String title) {
    return find(book -> book.getTitle().equalsIgnoreCase(title));
  }

  public List<Book> findByAuthor(String author) {
    return find(book -> book.getAuthor().equalsIgnoreCase(author));
  }

  public List<Book> findByPubYear(int pubYear) {
    return find(book -> book.getPublishingYear() == pubYear);
  }

  public List<Book> find(Predicate predicate){
    List<Book> newList = new ArrayList<Book>();
    for(Book book: catalog) {
      if(predicate.equalsBook(book)){
        newList.add(book);
      }
    }
    return newList;
  }
}

interface Predicate {
  boolean equalsBook(Book book);
}
