import java.util.LinkedList;
import java.util.Objects;

public class Main_3_5 {
    /*
    Zadanie składa się z dwóch części.
    Część 1 dla LinkedList
    Stwórz klasę reprezentującą książkę o nazwie Book. Klasa powinna mieć dwa pola: author oraz title.
    Pamiętaj o implementacji metod hashCode() oraz equals(Object o). Będziemy jej używali jako obiektów kolekcji LinkedList.
    Stwórz program, który zmierzy czas operacji wyszukiwania i usunięcia obiektu na początku (z użyciem metody remove(Object o)),
    wyszukiwania i usunięcia obiektu na końcu (z użyciem metody remove(Object o)),
    wstawiania na początku oraz wstawiania na końcu listy LinkedList liczącej kilka milionów obiektów.
    Część 2 dla HashMap
    Stwórz program, który zmierzy czas operacji wyszukiwania po kluczu, a także czas dodawania
    i usuwania obiektu z mapy HashMap liczącej kilka milionów obiektów.
    */
    public static void main(String[] args) {
        int sizeOfTheListOfItems = 2_000_000;
        TimeMeasurement howLong = new TimeMeasurement();
        howLong.timeMeasurement("START");
        BookListFiller bookListFiller = new BookListFiller();
        LinkedList<Book> booksLinkedList = bookListFiller.bookListFiller(sizeOfTheListOfItems);

        System.out.println("The number of items in the list: " + booksLinkedList.size());
        howLong.timeMeasurement("STOP");
    }
}

class TimeMeasurement {
    private boolean isTimeMeasurmentStarted;
    private long startTime;
    private long estimatedTime;

    TimeMeasurement() {
        startTime = 0;
        isTimeMeasurmentStarted = false;
    }

    void timeMeasurement(String use_Start_Or_Stop_Word) {
        switch (use_Start_Or_Stop_Word.toLowerCase()) {
            case "start":
                startTime = System.currentTimeMillis();
                isTimeMeasurmentStarted = true;
                break;
            case "stop":
                if (isTimeMeasurmentStarted == true) {
                    estimatedTime = System.currentTimeMillis() - startTime;
                    System.out.println("The task completion time was: " + estimatedTime + "ms.");
                }
                break;
            default:
                System.out.println("Only two switches allowed: START and STOP.");
        }
    }
}

class BookListFiller {
    LinkedList<Book> bookListFiller(int elementsQuantity) {
        LinkedList<Book> booksLinkedList = new LinkedList<>();
        for (int i = 0; i < elementsQuantity; i++) {
            booksLinkedList.add(new Book(("Great Name_" + i), ("Interesting title_" + i)));
        }
        return booksLinkedList;
    }
}

class Book {
    private String author;
    private String title;

    Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

