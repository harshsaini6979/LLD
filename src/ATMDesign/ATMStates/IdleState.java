package ATMDesign.ATMStates;

import ATMDesign.ATMMachine;
import ATMDesign.Card;

import java.util.Scanner;

public class IdleState extends ATMState{
    ATMMachine atmMachine;
    Card card;

    public IdleState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
        insertCard();
    }

    public void insertCard() {
        System.out.print("Enter your card number: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (atmMachine.getCards().containsKey(input)) {
            System.out.println("Card inserted successfully.");
            card = atmMachine.getCards().get(input);

            atmMachine.setATMState(new ProcessingState(atmMachine, card));
            atmMachine.getATMState().authentication();
        } else {
            System.out.println("Invalid input. Please try again.");
            atmMachine.setATMState(new IdleState(atmMachine));
        }
    }
}
