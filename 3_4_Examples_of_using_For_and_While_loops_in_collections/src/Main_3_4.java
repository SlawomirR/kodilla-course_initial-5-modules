import java.util.ArrayDeque;
import java.util.ArrayList;
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
        arrayListDivider(arrayDequeFiller());
    }

    static private ArrayDeque<String> arrayDequeFiller() {
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
        return arrayDeque;
    }

    static private void arrayListDivider(ArrayDeque<String> stringArrayDeque) {
        ArrayList<String> oddStringArrayList = new ArrayList<>();
        ArrayList<String> evenStringArrayList = new ArrayList<>();
        while (stringArrayDeque.peek() != null) {
            if ((stringArrayDeque.peek().length() % 2) == 0) {
                evenStringArrayList.add(stringArrayDeque.poll());
            } else {
                oddStringArrayList.add(stringArrayDeque.poll());
            }
        }
        System.out.println("We have " + oddStringArrayList.size() + " odd entries and " + evenStringArrayList.size() + " even ones");
        System.out.println("Odd string list:");
        for (String tmp: oddStringArrayList) {
            System.out.println(tmp);
        }
        for (String tmp: evenStringArrayList) {
            System.out.println(tmp);
        }
    }
}
