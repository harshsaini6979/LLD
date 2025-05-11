package ATMDesign.ATMStates;

import ATMDesign.ATMMachine;
import ATMDesign.Card;

import java.util.Scanner;

public class ProcessingState extends ATMState{
    ATMMachine atmMachine;
    Card card;

    public ProcessingState(ATMMachine atmMachine, Card card) {
        this.atmMachine = atmMachine;
        this.card = card;
    }

    public void authentication() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your PIN: ");
        String pin = scanner.nextLine();

        if (pin.equals(card.getPin())) {
            System.out.println("Hello " + card.getCardHolderName());

            System.out.println("Authentication successful!!");

            atmMachine.setATMState(new SelectionState(atmMachine, card));
        } else {
            System.out.println("Authentication failed. Please try again.");
            atmMachine.setATMState(new IdleState(atmMachine));
        }
    }
}
