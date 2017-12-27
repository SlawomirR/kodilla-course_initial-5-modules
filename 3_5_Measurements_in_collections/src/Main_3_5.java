import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Main_3_5 {
    /*
    Zadanie składa się z dwóch części.
    Część 1 dla LinkedList
    Stwórz klasę reprezentującą książkę o nazwie Book, która ma dwa pola: author oraz title.
    Zaimplementuj metody hashCode() oraz equals(Object o). Klasa Book będzie dla obiektów kolekcji LinkedList.
    Stwórz program, który zmierzy czas operacji:
    wyszukiwania i usunięcia obiektu na początku (z użyciem metody remove(Object o)),
    wyszukiwania i usunięcia obiektu na końcu (z użyciem metody remove(Object o)),
    wstawiania na początku oraz wstawiania na końcu listy LinkedList liczącej kilka milionów obiektów.
    Część 2 dla HashMap
    Stwórz program, który zmierzy czas operacji:
    wyszukiwania po kluczu,
    dodawania nowej pary
    usuwania obiektu z mapy HashMap liczącej kilka milionów obiektów.
    */
    public static void main(String[] args) {
        int sizeOfTheListOfItems = 1_000_000;
        TimeMeasurement howLong = new TimeMeasurement();

        // == PART 1 == LinkedList ==
        ProcessingLinkedList processingLinkedList = new ProcessingLinkedList();
        processingLinkedList.process(howLong, new BookListFiller(), sizeOfTheListOfItems);

        // == PART 2 == HashMap ==
        ProcessHashMap processHashMap = new ProcessHashMap();
        processHashMap.process(howLong, new BookMapFiller(), sizeOfTheListOfItems);
    }
}

class ProcessingLinkedList {
    void process(TimeMeasurement howLong, BookListFiller bookListFiller, int sizeOfTheListOfItems) {
        Book firstObject = new Book("StartName", "StartTitle");
        Book lastObject = new Book("StopName", "StopTitle");
        // Creating
            howLong.timeMeasurement("START","");
        LinkedList<Book> booksLinkedList = bookListFiller.bookListFiller(sizeOfTheListOfItems);
            howLong.timeMeasurement("STOP","Create "+booksLinkedList.size()+" items in the List took: ");

        // Removing
            howLong.timeMeasurement("START","");
        booksLinkedList.remove(firstObject);
            howLong.timeMeasurement("STOP","Removing the first object took: ");
            howLong.timeMeasurement("START","");
        booksLinkedList.remove(lastObject);
            howLong.timeMeasurement("STOP","Removing the last object from the list lasted: ");

        // Adding
            howLong.timeMeasurement("START","");
        booksLinkedList.add(firstObject); // or .add(0, new Book("StartName", "StartTitle"));
            howLong.timeMeasurement("STOP","Adding the first object to the list took: ");
            howLong.timeMeasurement("START","");
        booksLinkedList.addLast(lastObject); //or .add(booksLinkedList.size(), new Book("StopName", "StopTitle"));
            howLong.timeMeasurement("STOP","Adding the object at the end took: ");
    }
}

class ProcessHashMap {
    private Book firstObject = new Book("StartName", "StartTitle");
    private Book lastObject = new Book("StopName", "StopTitle");
    void process(TimeMeasurement howLong, BookMapFiller bookMapFiller, int sizeOfTheListOfItems) {
        //Creating
            howLong.timeMeasurement("START", "");
        HashMap<Book, Integer> booksHashMap = bookMapFiller.bookMapFiller(sizeOfTheListOfItems);
            howLong.timeMeasurement("STOP", "Create " + booksHashMap.size() + " items in the map took: ");

        // Finding
            howLong.timeMeasurement("START", "");
        System.out.println("Did we find: " + lastObject + " -> " + booksHashMap.containsKey(lastObject));
            howLong.timeMeasurement("STOP", "Finding the Key in the Map took: ");

        // Removing
            howLong.timeMeasurement("START", "");
        booksHashMap.remove(firstObject);
            howLong.timeMeasurement("STOP", "Removing the object from the Map took: ");

        // Adding
            howLong.timeMeasurement("START", "");
        booksHashMap.put(firstObject, sizeOfTheListOfItems+1);
            howLong.timeMeasurement("STOP", "Adding the object to the Map took: ");

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

final class Book {
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
        return "Book{" + "author='" + author + '\'' + ", title='" + title + '\'' + '}';
    }
}

final class TimeMeasurement {
    private boolean isTimeMeasurementStarted;
    private long startTime;

    TimeMeasurement() {
        startTime = 0;
        isTimeMeasurementStarted = false;
    }

    void timeMeasurement(String use_Start_Or_Stop_Word, String informativeCommentary) {
        switch (use_Start_Or_Stop_Word.toLowerCase()) {
            case "start":
                startTime = System.currentTimeMillis();
                isTimeMeasurementStarted = true;
                break;
            case "stop":
                if (isTimeMeasurementStarted) {
                    long estimatedTime = System.currentTimeMillis() - startTime;
                    System.out.print(informativeCommentary);
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
