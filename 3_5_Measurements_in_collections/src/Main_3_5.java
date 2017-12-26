import java.util.HashMap;
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
        int sizeOfTheListOfItems = 1_000_000;
        TimeMeasurement howLong = new TimeMeasurement();
        Book firstObject = new Book("StartName", "StartTitle");
        Book lastObject = new Book("StopName", "StopTitle");

        // == PART 1 ==
        BookListFiller bookListFiller = new BookListFiller();

        howLong.timeMeasurement("START");
        LinkedList<Book> booksLinkedList = bookListFiller.bookListFiller(sizeOfTheListOfItems);
        System.out.print("Create " + booksLinkedList.size() + " items in the List took: ");
        howLong.timeMeasurement("STOP");

        howLong.timeMeasurement("START");
        booksLinkedList.remove(firstObject);
        System.out.print("Removing the first object took: ");
        howLong.timeMeasurement("STOP");
        howLong.timeMeasurement("START");
        booksLinkedList.remove(lastObject);
        System.out.print("Removing the last object from the list lasted: ");
        howLong.timeMeasurement("STOP");
        System.out.println("The list has " + booksLinkedList.size() + " items.");

        howLong.timeMeasurement("START");
        booksLinkedList.add(firstObject); // or .add(0, new Book("StartName", "StartTitle"));
        System.out.print("Adding the first object to the list took: ");
        howLong.timeMeasurement("STOP");
        howLong.timeMeasurement("START");
        booksLinkedList.addLast(lastObject); //or .add(booksLinkedList.size(), new Book("StopName", "StopTitle"));
        System.out.print("Adding the object at the end took: ");
        howLong.timeMeasurement("STOP");
        System.out.println("The list has " + booksLinkedList.size() + " items.");

        // == PART 2 ==
        BookMapFiller bookMapFiller = new BookMapFiller();

        howLong.timeMeasurement("START");
        HashMap<Book, Integer> booksHashMap = bookMapFiller.bookMapFiller(sizeOfTheListOfItems);
        System.out.print("Create " + booksLinkedList.size() + " items in the map took: ");
        howLong.timeMeasurement("STOP");

        howLong.timeMeasurement("START");
        System.out.println("Did we find: " + lastObject + " -> " + booksHashMap.containsKey(lastObject));
        System.out.print("Finding the Key in the Map took: ");
        howLong.timeMeasurement("STOP");

        howLong.timeMeasurement("START");
        booksHashMap.remove(firstObject);
        System.out.print("Removing the object from the Map took: ");
        howLong.timeMeasurement("STOP");

        howLong.timeMeasurement("START");
        booksHashMap.put(firstObject, sizeOfTheListOfItems+1);
        System.out.print("Adding the object to the Map took: ");
        howLong.timeMeasurement("STOP");

    }
}

class TimeMeasurement {
    private boolean isTimeMeasurementStarted;
    private long startTime;

    TimeMeasurement() {
        startTime = 0;
        isTimeMeasurementStarted = false;
    }

    void timeMeasurement(String use_Start_Or_Stop_Word) {
        switch (use_Start_Or_Stop_Word.toLowerCase()) {
            case "start":
                startTime = System.currentTimeMillis();
                isTimeMeasurementStarted = true;
                break;
            case "stop":
                if (isTimeMeasurementStarted) {
                    long estimatedTime = System.currentTimeMillis() - startTime;
                    System.out.println(estimatedTime + "ms.");
                    isTimeMeasurementStarted = false;
                } else {
                    System.err.println("WARNING: You missed to set START point so all measurements are broken!");
                }
                break;
            default:
                System.err.println("WARNING: Only two switches allowed: START and STOP.");
        }
    }
}

class BookListFiller {
    LinkedList<Book> bookListFiller(int elementsQuantity) {
        LinkedList<Book> booksLinkedList = new LinkedList<>();
        booksLinkedList.add(new Book("StartName", "StartTitle"));
        for (int i = 0; i < elementsQuantity; i++) {
            booksLinkedList.add(new Book(("Great Name_" + i), ("Interesting title_" + i)));
        }
        booksLinkedList.add(new Book("StopName", "StopTitle"));
        return booksLinkedList;
    }
}

class BookMapFiller {
    HashMap<Book, Integer> bookMapFiller(int elementsQuantity) {
        HashMap<Book, Integer> booksHashMap = new HashMap<>(elementsQuantity + 20, 1);
        booksHashMap.put(new Book("StartName", "StartTitle"), elementsQuantity + 1);
        for (int i = 0; i < elementsQuantity; i++) {
            booksHashMap.put(new Book(("Great Name_" + i), ("Interesting title_" + i)), i);
        }
        booksHashMap.put(new Book("StopName", "StopTitle"), elementsQuantity + 2);
        return booksHashMap;
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

