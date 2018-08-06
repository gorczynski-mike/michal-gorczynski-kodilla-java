package com.kodilla.patterns2.adapter.bookclassifier.libraryb;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics implements BookStatistics {

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        if(books.size() == 0) return 0;
        return books.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.averagingInt(Book::getPublicationYear)).intValue();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        if(books.size() == 0) return 0;
        Integer[] years = books.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(Book::getPublicationYear)
                .collect(Collectors.toList()).toArray(new Integer[0]);
        Arrays.sort(years);
        if(years.length%2 == 0) {
            return years[(int)(years.length / 2 + 0.5)];
        } else {
            return years[years.length/2];
        }
    }
}
