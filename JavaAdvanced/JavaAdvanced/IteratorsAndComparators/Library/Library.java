package Tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    private class LibIterator implements Iterator<Book> {
        private int i = 0;

    @Override
    public boolean hasNext() {
        return this.i < books.size();
    }

    @Override
    public Book next() {
        Book nextBook = books.get(this.i);
        this.i++;

        return nextBook;
    }
}

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
