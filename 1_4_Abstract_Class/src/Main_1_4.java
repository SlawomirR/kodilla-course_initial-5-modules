/*
Zadanie: Transakcja bankowa

Aby przećwiczyć wykorzystywanie klas abstrakcyjnych w praktyce, stwórz swoje własne zachowanie dla transakcji bankowej.
Załóżmy, że transakcja bankowa zawiera się w 8 metodach, z czego 3 są zawsze po stronie banku (w klasie abstrakcyjnej).
Schemat transakcji bankowej do zaimplementowania:
    Prośba o wprowadzenie karty (Bankomat)
    Prośba o wprowadzenie kodu PIN (Bankomat)
    Prośba o wprowadzenie kwoty do wypłaty (Bankomat)
    Informacja o przyjęciu prośby wypłaty przez Bank (Bank)
    Sprawdzenie stanu konta (Bank)
    Potwierdzenie możliwości wypłaty (Bank)
    Wypłacanie gotówki (Bankomat)
    Podziękowanie za skorzystanie z usług Banku (Bankomat)
Załóż, że każde z tych działań sygnalizujemy zwykłym println.
*/
public class Main_1_4 {
    public static void main(String[] args) {
        TransactionRunner makeTransaction = new TransactionRunner();
        makeTransaction.run();
    }
}

abstract class ATM_Transaction {
    protected void run() {
        this.insertCard();
        this.inputPin();
        this.amountOfMoney();
        this.requestReceived();
        this.bankAccountStatus();
        this.possibilityOfWithdrawal();
        this.withdrawingCash();
        this.thanksMessage();
    }

    private void insertCard() {
        System.out.println("1. Please insert your credit card");
    }

    private void inputPin() {
        System.out.println("2. Input your PIN code ...");
    }

    private void amountOfMoney() {
        System.out.println("3. Input desired amount of money you want to withdraw ...");
    }

    protected abstract void requestReceived();

    protected abstract void bankAccountStatus();

    protected abstract void possibilityOfWithdrawal();

    protected void withdrawingCash() {
        System.out.println("7. Take your money.");
    }

    private void thanksMessage() {
        System.out.println("8. Thanks for using our service.");
    }
}

class TransactionRunner extends ATM_Transaction {
    @Override
    protected void requestReceived() { // Received
        System.out.println("4. We received your money withdraw request.");
    }

    @Override
    protected void bankAccountStatus() {
        System.out.println("5. You still have a positive balance on your bank account");
    }

    @Override
    protected void possibilityOfWithdrawal() {
        System.out.println("6. You have possibility of withdrawal ... so ... we're processing your request.");
    }

    @Override
    protected void withdrawingCash() {
        System.out.println("\"(Nadpisane) >6 i <8 = 7. Take your money.\"");
    }
}