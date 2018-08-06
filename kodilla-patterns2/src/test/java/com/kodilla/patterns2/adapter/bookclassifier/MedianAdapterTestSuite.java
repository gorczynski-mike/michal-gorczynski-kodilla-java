package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedian() {
        //Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("author1", "title1", 2003, "signature1"));
        books.add(new Book("author1", "title1", 2009, "signature1"));
        books.add(new Book("author1", "title1", 2000, "signature1"));
        books.add(new Book("author1", "title1", 1970, "signature1"));
        books.add(new Book("author1", "title1", 1999, "signature1"));
        //When
        MedianAdapter medianAdapter = new MedianAdapter();
        int bookPublicationYearMedian = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(2000, bookPublicationYearMedian);
    }
}