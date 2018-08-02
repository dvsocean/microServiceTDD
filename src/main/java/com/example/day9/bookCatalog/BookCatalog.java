package com.example.day9.bookCatalog;

import java.util.HashMap;

public class BookCatalog {

  private HashMap<String, Book> catalog = new HashMap<>();

  public BookCatalog(){
    for (int i = 0; i < 100; i++) {
      catalog.put("John Bevere", new Book("John Bevere", "Relentless", 2015));
      catalog.put("Joyce Meyer", new Book("Joyce Meyer", "Restart", 2012));
      catalog.put("John MacArthur", new Book("John MacArthur", "Altitude", 2014));
      catalog.put("Robert Morris", new Book("Robert Morris", "Pennies for the thought", 2010));
      catalog.put("Sara Jacobs", new Book("Sara Jacobs", "What it means to want", 2013));
      catalog.put("Michael Smith", new Book("Michael Smith", "Cry for love", 1998));
      catalog.put("Ruki v Verh", new Book("Ruki v Verh", "Raberay menya sokrey", 1995));
    }
  }

  public HashMap<String, Book> getCatalog(){
    return this.catalog;
  }

  public Book searchByAuthorName(String author) {
    return catalog.get(author);
  }

  public Book searchByTitle(String title){
    Book book = null;
    for(Book b: catalog.values()) {
      if(b.getTitle().contains(title)){
        book = b;
      }
    }
    return book;
  }

  public Book searchByPublishedYear(int pubYear) {
    Book book = null;
    for(Book b: catalog.values()) {
      if(b.getPublishing_year() == pubYear){
        book = b;
      }
    }
    return book;
  }
}
