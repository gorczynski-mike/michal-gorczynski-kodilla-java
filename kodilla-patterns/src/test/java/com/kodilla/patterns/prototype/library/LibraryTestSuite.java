package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library libraryOriginal = new Library("Original");
        IntStream.iterate(1, n -> n + 1)
                .limit(6)
                .forEach(n -> libraryOriginal.getBooks().add(new Book("Title" + n, "Author" + n, LocalDate.now())));
        Library shallowCopy, deepCopy;
        try {
            shallowCopy = libraryOriginal.shallowCopy();
            shallowCopy.setName("Shallow");
            deepCopy = libraryOriginal.deepCopy();
            deepCopy.setName("Deep");


        //When
        libraryOriginal.getBooks().add(new Book("TitleTest1", "AuthorTest1", LocalDate.now()));
        shallowCopy.getBooks().add(new Book("TitleTest2", "AuthorTest2", LocalDate.now()));
        deepCopy.getBooks().removeIf(book -> book.getTitle().equalsIgnoreCase("Title1"));
        System.out.println(libraryOriginal);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);

        //Then
            Assert.assertEquals(8, libraryOriginal.getBooks().size());
            Assert.assertEquals(8, shallowCopy.getBooks().size());
            Assert.assertEquals(5, deepCopy.getBooks().size());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
