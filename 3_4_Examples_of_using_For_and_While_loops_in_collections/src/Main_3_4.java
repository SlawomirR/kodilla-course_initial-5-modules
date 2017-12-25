import java.util.ArrayDeque;
import java.util.Random;

public class Main_3_4 {
    /*
    Zadanie składa się z dwóch części:
    Część 1
    1. Napisz program, który w kolejce ArrayDeque umieści 50 obiektów przechowujących napisy,
    składające się z litery 'a' powtórzonej losową ilość razy (zakres powtórzeń: 1 - 50).
    2. Wypełnienie obiektu powtórzeniami litery 'a' zrealizuj przy pomocy pętli for.
    Część 2
    1. Program z części pierwszej rozbuduj w taki sposób, że przekażesz utworzoną kolejkę do
    metody Twojej klasy, która dokona rozdzielenia obiektów z kolejki na dwie kolekcje ArrayList.
    2. Jedna z nich będzie przechowywała obiekty o parzystej ilości znaków 'a', a druga o nieparzystej.
    */
    public static void main(String[] args) {
        arrayDequeFiller();
    }

    static private void arrayDequeFiller() {
        Random random = new Random();
        int aStringSize;
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 50; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            aStringSize = random.nextInt(50) + 1;
            for (int j = 0; j < aStringSize; j++) {
                stringBuilder.append("a");
            }
            arrayDeque.offer(stringBuilder.toString());
        }
        System.out.println(arrayDeque);

    }
}
