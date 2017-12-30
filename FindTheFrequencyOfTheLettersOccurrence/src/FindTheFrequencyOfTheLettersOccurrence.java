import java.util.ArrayList;
import java.util.Collections;
/*
Napisz program zliczajacy ile razy w wyrazie występuje dana litera, np:
podajesz wyraz - programowanie
podajesz litere - r
rezultat: 2
*/
public class FindTheFrequencyOfTheLettersOccurrence {
    public static void main(String[] args) {
        String findLetter = "r";
        String sampleText = "Programowanie jest wspaniałym zajęciem dla programistów lubiących programować i tworzyć programy dla innych";
        ArrayList<String> sss = new ArrayList<>();
        for (int i = 0; i< sampleText.length(); i++) {
            sss.add(String.valueOf(sampleText.charAt(i)));
        }
        System.out.println("The letter \"" + findLetter + "\" occures: " + Collections.frequency(sss, findLetter) + " times.");
    }
}
