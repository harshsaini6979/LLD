package ATMDesign.ATMStates;

import ATMDesign.ATMMachine;
import ATMDesign.Card;

import java.util.Scanner;

public class CashWithdrawState extends ATMState {
    ATMMachine atmMachine;
    Card card;

    public CashWithdrawState(ATMMachine atmMachine, Card card) {
        this.atmMachine = atmMachine;
        this.card = card;

        withdraw();
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw only in multiple of 100 (enter -1 to exit): ");

        int amount = scanner.nextInt();

        if (amount == -1) {
            System.out.println("Transaction cancelled.");
            atmMachine.setATMState(new IdleState(atmMachine));
        }
        else if (amount > card.getBankAccount().getBalance()) {
            System.out.println("Insufficient balance.");
            withdraw();
        } else {
            boolean success = atmMachine.withdrawCash(card, amount);

            if (!success) {
                System.out.println("Insufficient cash in ATM.");
                atmMachine.setATMState(new IdleState(atmMachine));
            } else {
                System.out.println("Transaction successful. Please take your cash.");
                card.getBankAccount().setBalance(card.getBankAccount().getBalance() - amount);
                atmMachine.setATMState(new IdleState(atmMachine));
            }
        }
    }
}
