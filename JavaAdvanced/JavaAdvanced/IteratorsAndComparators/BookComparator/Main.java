package Tasks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library();
        library.add(bookOne);
        library.add(bookTwo);
        library.add(bookThree);

        List<Book> books = library.getBooks();

        books.stream().sorted(new BookComparator()).forEach(System.out::println);
    }
}
