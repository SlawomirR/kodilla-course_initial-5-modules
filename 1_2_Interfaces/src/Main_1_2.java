public class Main_1_2 { // Bankomat version 1.0
        public static void main(String[] args) {
            ATMImpl atm = new ATMImpl();

            // wykonanie wpłaty
            atm.payment();

            // co się dzieje z naszym działaniem
            atm.bankConnectionStatus();

            // wybieramy pieniądze
            atm.withdrawal();

            // chcemy odejść
            ATM.cashpointEndProcess();
        }
    }

    class ATMImpl implements ATM {

        @Override
        public void payment() {
            System.out.println("\nMake your payment ...");
            System.out.println(" ... done SUCCESSFUL");
        }

        @Override
        public void withdrawal() {
            System.out.println("\nTake your money back ...");
            System.out.println(" ... done SUCCESSFUL");
        }
    }

    interface ATM {
        void payment(); // wpłata - wymaga implementacji pod własne potrzeby

        void withdrawal(); // wypłata - wymaga implementacji pod własne potrzeby

        default void bankConnectionStatus() {	// gotowa informacja o wykonywanym połączeniu
            System.out.println("\nMaking connection with bank ... SUCCESS!");
        }

        static void cashpointEndProcess() {	// zakończenie pracy z bankomatem
            System.out.println("\n... disconnected succesful - you can leave now.");
        }
    }

