import java.util.ArrayDeque;
import java.util.Objects;

class Main_3_2 {
    public static void main(String[] args) {
        ArrayDeque<Book> books = new ArrayDeque<>();
        buildNewBookStack(books);
        processTasksWithBooks(books);
        buildNewBookStack(books);
        cancelingTasksWithBooks(books);
    }

    private static void processTasksWithBooks(ArrayDeque<Book> books) {
        Book temporaryItem = new Book();
        while (books.peek() != null) {
            temporaryItem = books.poll();
            System.out.println("We are processing " + temporaryItem);
        }
        System.out.println(temporaryItem.toString() + " was the last book we processed.");
        System.out.println("How many books left? -> " + books.size());
    }

    private static void cancelingTasksWithBooks(ArrayDeque<Book> books) {
        System.out.println("We clean up all book at once");
        books.clear();
        System.out.println("We have " + books.size() + " books in our queue");
    }

    private static void buildNewBookStack(ArrayDeque<Book> books) {
        System.out.println("Books added to the queue:");
        int maxBooksNumber = 5;
        for (int i = 1; i < maxBooksNumber + 1; i++) {
            books.push(new Book("Book_" + i, "Author_" + i, calculateFakeYearOfPublish(i)));
            System.out.println(i + ". Book_" + i + " Author_" + i + " " + calculateFakeYearOfPublish(i));
        }
        System.out.println("We have " + books.size() + " books in our queue");
    }

    private static int calculateFakeYearOfPublish(int currentBookNumber) {
        return 2018 - 3*currentBookNumber;
    }
}

final class Book {
    private String title;
    private String author;
    private int year;

    Book() {}
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