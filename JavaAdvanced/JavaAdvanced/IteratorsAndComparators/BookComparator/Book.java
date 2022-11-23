package Tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
    }

    @Override
    public int compareTo(Book book) {
        int compared = this.title.compareTo(book.getTitle());

        if (compared == 0) {
          compared = Integer.compare(this.year, book.getYear());
        }

        return compared;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}
