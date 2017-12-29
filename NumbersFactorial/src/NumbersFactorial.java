/*
Zadanie:
obliczanie silni podanej liczby
 */
public class NumbersFactorial {
    public static void main(String[] args) {
        int factorial = 5;
        System.out.print("Factorial " + factorial + "! = ");
        System.out.println(" = " + String.valueOf(calculateFactorial(factorial)));
    }

    private static int calculateFactorial(int n) {
        if (n == 1) {
            System.out.print(n);
            return 1;
        }
        System.out.print(n + " * ");
        n *= calculateFactorial(n - 1);
        return n;
    }
}
