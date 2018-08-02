package com.example.withFelssey;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.example.withFelssey.bookCatalog.Book;
import com.example.withFelssey.bookCatalog.BookCatalog;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class WithFelsseyTests {

  private BookCatalog catalog;

  @Before
  public void setUp() throws Exception {
    catalog = new BookCatalog();
    catalog.addBook(new Book("Relentless", "John Bevere", 2014));
    catalog.addBook(new Book("Harry Potter", "Wise old man", 2014));
    catalog.addBook(new Book("Superman", "Clark Kent", 2014));
  }

  @Test
  public void shouldNotRetrieveBookWhenNoTitleIsFound() {
    List<Book> books = catalog.findByTitle("My Book");
    assertThat(books.size(), is(0));
  }

  @Test
  public void shouldReturnCorrectBookWhenTitleMatches(){
    List<Book> books = catalog.findByTitle("Relentless");
    assertThat(books.size(), is(1));
  }

  @Test
  public void shouldBeAbleToFindABookByAuthorName() {
    List<Book> books = catalog.findByAuthor("John Bevere");
    assertThat(books.size(), is(1));
    assertThat(books.get(0).getAuthor(), is("John Bevere"));
  }

  @Test
  public void shouldBeAbleToRetrieveBookByPublishingYear() {
    List<Book> books = catalog.findByPubYear(2014);
    assertThat(books.size(), is(3));
    assertThat(books.get(0).getPublishingYear(), is(2014));
  }
}
