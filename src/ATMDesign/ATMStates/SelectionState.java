package ATMDesign.ATMStates;

import ATMDesign.ATMMachine;
import ATMDesign.Card;

import java.util.Scanner;

public class SelectionState extends ATMState {
    ATMMachine atmMachine;
    Card card;

    public SelectionState(ATMMachine atmMachine, Card card) {
        this.atmMachine = atmMachine;
        this.card = card;

        selectionOperation();
    }

    public void selectionOperation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Withdraw cash");
        System.out.println("2. Check Bank Balance");
        System.out.println("3. Exit");
        System.out.print("Please select your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                atmMachine.setATMState(new CashWithdrawState(atmMachine, card));
                break;
            case 2:
                atmMachine.setATMState(new BalanceEnquiryState(atmMachine, card));
                break;
            case 3:
                atmMachine.setATMState(new IdleState(atmMachine));
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                selectionOperation();
                break;
        }
    }
}
