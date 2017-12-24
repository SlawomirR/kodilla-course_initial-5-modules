import java.util.HashSet;
import java.util.Objects;

class Main_3_1 {
    public static void main(String[] args) {
        int maxBooksNumber = 9;
        int limitingSearchYear = 2010;
        int baseYearForCalculation = limitingSearchYear - 5;
        HashSet<Book> books = new HashSet<>();
        System.out.println("Books added to the set:");
        for (int i = 1; i < maxBooksNumber + 1; i++) {
            books.add(new Book("Book_" + i, "Author_" + i, baseYearForCalculation+maxBooksNumber+1-2*i+2));
            System.out.println(i + ". Book_" + i + " Author_" + i + " " + (baseYearForCalculation+maxBooksNumber+1-2*i+2));
        }
        System.out.println("We have " + books.size() + " books in our set.");
        System.out.println("Books published before " + limitingSearchYear + ":");
        int index = 0;
        for (Book book: books) {
            if (book.getYear() < limitingSearchYear) {
                index++;
                System.out.println(index + ". " + book);
            }
        }
    }
}

final class Book {
    private String title;
    private String author;
    private int year;

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
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
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
