package ATMDesign.ATMStates;

import ATMDesign.ATMMachine;
import ATMDesign.Card;

public abstract class ATMState {
    public void insertCard() {
        System.out.println("Not a valid operation");
    }

    public void authentication() {
        System.out.println("Not a valid operation");
    }

    public void selectionOperation() {
        System.out.println("Not a valid operation");
    }

    public void withdraw() {
        System.out.println("Not a valid operation");
    }

    public void checkBalance() {
        System.out.println("Not a valid operation");
    }
}
