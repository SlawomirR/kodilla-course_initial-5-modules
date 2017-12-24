import java.util.ArrayDeque;
import java.util.Objects;

public class Main_3_2 {
    public static void main(String[] args) {
        int maxBooksNumber = 5;
        int baseYearForCalculation = 2005;
        ArrayDeque<Book> books = new ArrayDeque<>();
        System.out.println("We work with: " + books.getClass());
        System.out.println("What is the size of the queue: " + books.size());
        System.out.println("Books added to the queue:");
        // dodanie książek na stos
        for (int i = 1; i < maxBooksNumber + 1; i++) {
            books.push(new Book("Book_" + i, "Author_" + i, baseYearForCalculation+maxBooksNumber+1-2*i+2));
            System.out.println(i + ". Book_" + i + " Author_" + i + " " + (baseYearForCalculation+maxBooksNumber+1-2*i+2));
        }
        System.out.println("We have " + books.size() + " books in our queue");
        // zdejmowanie kolejnych książek ze stosu
        while (books.size() > 1) {
            System.out.println("We are processing " + books.peek());
            System.out.println("taking out " + books.poll() + " ... done");
            System.out.println("Left " + books.size() + " books to proceed.");
        }
        System.out.print("The last book we can process is: ");
        System.out.println(books.getLast());
        System.out.println(" ... so taking out last one: " + books.poll() + " ... done.");
        System.out.println("How many books left? -> " + books.size());
        System.out.println("New books added to the queue:");
        // nowe dodanie książek na stos
        for (int i = 1; i < maxBooksNumber + 1; i++) {
            books.push(new Book("Book_" + i, "Author_" + i, baseYearForCalculation+maxBooksNumber+1-2*i+2));
            System.out.println(i + ". Book_" + i + " Author_" + i + " " + (baseYearForCalculation+maxBooksNumber+1-2*i+2));
        }
        System.out.println("We have " + books.size() + " books in our queue");
        System.out.println("We clean up all book at once");
        books.clear();
        System.out.println("We have " + books.size() + " books in our queue");
    }
}

final class Book {
    private String title;
    private String author;
    private int year;

    public int getYear() {
        return year;
    }

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Book{" + title + '\'' + author + '\'' + year + '}';
    }
}
