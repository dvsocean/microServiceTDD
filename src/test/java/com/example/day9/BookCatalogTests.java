package com.example.day9;

import static org.junit.Assert.assertEquals;

import com.example.day9.bookCatalog.Book;
import com.example.day9.bookCatalog.BookCatalog;
import org.junit.Before;
import org.junit.Test;

public class BookCatalogTests {

  private BookCatalog cat;

  @Before
  public void setup(){
    cat = new BookCatalog();
  }

  @Test
  public void shouldBeAbleToRetrieveBookByAuthor(){
    Book res = cat.searchByAuthorName("Sara Jacobs");
    assertEquals("Sara Jacobs", res.getAuthor());
  }

  @Test
  public void shouldBeAbleToRetrieveBookByTitle(){
    Book res = cat.searchByTitle("Relentless");
    assertEquals("Relentless", res.getTitle());
  }

  @Test
  public void shouldBeAbleToRetrieveBookByPublishingYear(){
    Book res = cat.searchByPublishedYear(2014);
    assertEquals(2014, res.getPublishing_year());
  }
}
