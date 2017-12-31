/*
Zadanie: Obliczamy średnią
Napisz program obliczający wartość średnią 20 elementów tablicy.
Pamiętaj:
    Elementy tablicy powinny być typu int.
    Pamiętaj, że wynik prawdopodobnie nie będzie wartością całkowitą.
    Pętla powinna wyświetlić wszystkie elementy tablicy.
    Na koniec powinna zostać wyświetlona wartość średniej.
*/
public class Main_2_1 {
    public static void main(String[] args) {
        // liczba elementów tablicy
        int arraySize = 20;

        // deklaracja tablicy
        int[] array = new int[arraySize];

        // wypełnienie tablicy liczbami od 1 do arraySize
        for (int i = 0; i < arraySize; i++) {
            array[i] = i + 1;
        }

        // wyświetlenie elementów tablicy
        double sum = 0;
        System.out.print("Array {");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i]);
            // aby nie było przecinka po ostatniej liczbie
            if ((i+1) != arraySize) {
                System.out.print(", ");
            }
            sum += array[i];
        }
        // wyświetlenie średniej wartości
        System.out.println("}\nAverage value: " + sum + " / " + array.length + " = " + (sum/array.length));

    }
}
