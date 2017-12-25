import java.util.ArrayDeque;
import java.util.Random;

public class Main_3_3 {
    /*
    Napisz program, który:
    będzie posiadał zmienną int sumaA (zainicjowana z wartością 1000)
    oraz drugą zmienną int SumaB (zainicjowana z wartością 0).
    Pętle while, wewnątrz której losujemy:
    liczbę typu int z zakresu 0-9 i dodawaj ją do zmiennej sumaA oraz
    liczbę typu int z zakresu 0-49 i dodawaj ją do zmiennej sumaB.
    Pętlę wykonuj tak długo, jak długo spełniony jest warunek sumaA > sumaB.
    W każdej iteracji wyświetl numer przebiegu pętli oraz aktualne wartości obu zmiennych.
    */
    //ZMIANA DO ZADANIA: wyświetlić wyniki w odwrotej kolejności

    public static void main(String[] args) {
        comparingTheSummationForTwoVariables();
   }

    private static void comparingTheSummationForTwoVariables () {
        int sumaA = 1000;
        int sumaB = 0;
        int theCurrentIterationNumber = 0;
        Random random = new Random();
        String result ="";
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        while (sumaA > sumaB) {
            theCurrentIterationNumber++;
            sumaA += random.nextInt(10);
            sumaB += random.nextInt(50);
            result = "If sumaA > sumaB, attempt number #" + theCurrentIterationNumber + ": sumaA= " + sumaA + ", sumaB= " + sumaB;
            arrayDeque.push(result);
        }
        while (arrayDeque.peek() != null) {
            System.out.println(arrayDeque.poll());
        }
    }
}
