/*
Zadanie: średnia bez skrajnych ocen oraz lista obiektów Book
Zadanie składa się z dwóch części - jedna dotyczy ArrayList, a druga LinkedList.
Oba rozwiązania powinny być w ramach jednego projektu.

Część 1
    Napisz program przy użyciu listy ArrayList, zawierającej kilkanaście ocen z przedmiotu Informatyka w liceum.
    Wypełnij listę przykładowymi ocenami.

    Następnie przy pomocy pętli for oblicz średnią ocenę ucznia (średnia arytmetyczna), ale w taki sposób,
    że pominięte zostaną skrajne oceny - JEDNA najmniejsza i JEDNA największa.
    Oceny największą i najmniejszą należy odnaleźć. Przykładowo - dla ocen:
        3,3,4,4,4,5,5,5,6 - do obliczenia średniej wzięte zostaną oceny: 3,4,4,4,5,5,5
        4,4,4,4,4,4,4 - do obliczenia średniej wzięte zostaną oceny: 4,4,4,4,4

Część 2
    Napisz program przy użyciu listy LinkedList, zawierającej obiekty opisujące książki. Każda książka
    powinna posiadać tytuł i rok wydania.
    Wypełnij listę kilkoma przykładowymi pozycjami.
    Następnie przy pomocy pętli for-each wyświetl tylko te książki z listy, których rok wydania jest nie starszy niż 2000.
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main_2_5 {
    public static void main(String[] args) {
        System.out.println("== Start of Part 1 ==");
        ScoreList scoreList = new ScoreList();
        scoreList.scoreList();
        System.out.println("== End of Part 1 ==");
        System.out.println("== Start of Part 2 ==");
        BookList bookList = new BookList();
        bookList.processBookList();
        System.out.println("== End of Part 2 ==");
    }
}

class ScoreList {
    private int maxScore = Integer.MIN_VALUE;
    private int minScore = Integer.MAX_VALUE;
    private double sum = 0;
    private int arrayListSize = 9;

    private Random random = new Random();
    private ArrayList<Integer> arrayList = new ArrayList<>(arrayListSize);

    public void scoreList() {
        System.out.print("Otrzymane oceny: {");
        for (int i = 0; i < arrayListSize; i++) {
            int score = random.nextInt(6)+1;
            arrayList.add(score);
            sum += score;
            if (minScore > score) {
                minScore = score;
            }
            if (maxScore < score) {
                maxScore = score;
            }
            if (i != (arrayListSize - 1)) {
                System.out.print(arrayList.get(i) + ", ");
            } else {
                System.out.print(arrayList.get(i));
            }
        }
        System.out.println("}");
        System.out.println("Pominięte dwie oceny: " + minScore + " oraz " + maxScore);
        double average = (sum - minScore - maxScore) / (arrayListSize-2);
        System.out.println("Średnia z ocen: (" + sum + "-" + (minScore + maxScore) + ") / " + (arrayListSize-2) + " = " + String.format("%.2f", average));
    }
}

class BookList {
    private LinkedList<Book> bookLinkedList = new LinkedList<>();
    public void processBookList() {
        bookLinkedList.add(new Book("50 shades of Grey", 1978));
        bookLinkedList.add(new Book("Sherlock Holmes", 2000));
        bookLinkedList.add(new Book("The Last Mohikan", 1988));
        bookLinkedList.add(new Book("The infinity", 2014));
        bookLinkedList.add(new Book("Better Call Soul", 1999));
        bookLinkedList.add(new Book("A Journey Into the Earth", 2000));
        bookLinkedList.add(new Book("Binary Death", 2000));
        bookLinkedList.add(new Book("Breaking Bad", 2017));
        bookLinkedList.add(new Book("50000 miles undersea journey", 1994));
        bookLinkedList.add(new Book("the Titanfall", 2013));
        bookLinkedList.add(new Book("Coma", 2009));
        bookLinkedList.add(new Book("People and Ants", 2004));
        bookLinkedList.add(new Book("To understand the Woman", 2015));
        bookLinkedList.add(new Book("Neverending Story", 2012));
        bookLinkedList.add(new Book("Book of Jungle", 2000));
        System.out.println("Liczba wpisanych książek: " + bookLinkedList.size());
        System.out.println("Books equal or newer than 2000 are:");
        for (Book book: bookLinkedList) {
            if (book.year >= 2000) { System.out.println(book); }
        }
    }
}

class Book {
    // publiczne dla uproszczenia zadania
    private String book;
    public int year;

    Book(String book, int year) {
        this.book = book;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book: " + "\"" + book + "\"" + ", (" + year + ")";
    }
}
