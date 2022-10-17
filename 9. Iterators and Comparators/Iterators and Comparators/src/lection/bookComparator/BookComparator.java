package lection.bookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        int result = book1.getTitle().compareTo(book2.getTitle());

        // If the lection.book titles are equal
        if (result == 0) {
            // We compare them by their year
            result = Integer.compare(book1.getYear(), book2.getYear());
        }

        return result;
    }
}
