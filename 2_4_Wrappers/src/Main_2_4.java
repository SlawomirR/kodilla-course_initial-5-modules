/*
Zadanie: Wrapper prymitywowi (nie)równy?
Napisz program, przypisujący do zmiennych o typach prymitywnych, jakieś wartości.
Następnie takie same wartości przypisz do typów będących wrapperami typów prymitywnych.
Niech program porówna czy wartości w typach prymitywnych oraz odpowiadających im wrapperach są sobie równe.
Do realizacji zadania wybierz trzy dowolne typy prymitywne.
*/
public class Main_2_4 {
    public static void main(String[] args) {
        int anInt = 450;
        double aDouble = 450.450;
        char aChar = 'H';

        Integer anIntObject = 450;
        Double aDoubleObject = 450.450;
        Character aCharObject = 'H';

        System.out.println("Integer = int --> " + (anIntObject == anInt));
        System.out.println("Double = double --> " + (aDoubleObject == aDouble));
        System.out.println("Character = char --> " + (aCharObject == aChar));
    }
}
