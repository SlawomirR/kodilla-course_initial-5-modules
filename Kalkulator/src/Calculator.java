import java.util.Scanner;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    public static void main(String[] args) {
        double numberA, numberB;
        String sign;
        Calculator calculator = new Calculator();
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj pierwszą liczbę:");
        numberA = input.nextInt();
        System.out.print("Podaj drugą liczbę:");
        numberB = input.nextInt();input.nextLine();
        System.out.print("Podaj znak działania: + lub - Jaki wybór? ");
        sign = input.nextLine();
        switch (sign) {
            case PLUS:
                calculator.addition(numberA, numberB);
                break;
            case MINUS:
                calculator.subtraction(numberA, numberB);
                break;
            default:
                System.err.println("WARNING: Only sign of \"+\" or \"-\" are allowed to use!");
        }
    }

    private void addition(double numberA, double numberB) {
        System.out.println("Wynik dodawania: " + (numberA+numberB));
    }

    private void subtraction(double numberA, double numberB) {
        System.out.println("Wynik odejmowania: " + (numberA-numberB));
    }
}

