package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library implements Cloneable{

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library shallowCopy() throws CloneNotSupportedException{
        return (Library) this.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clone = (Library)this.clone();
        clone.books = new HashSet<>();
        for(Book book : this.books) {
            clone.books.add(new Book(book.getTitle(), book.getAuthor(), book.publicationDate));
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + System.lineSeparator() + books +
                '}';
    }
}
