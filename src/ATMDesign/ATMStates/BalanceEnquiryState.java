package ATMDesign.ATMStates;

import ATMDesign.ATMMachine;
import ATMDesign.Card;

public class BalanceEnquiryState extends ATMState {
    ATMMachine atmMachine;
    Card card;

    public BalanceEnquiryState(ATMMachine atmMachine, Card card) {
        this.atmMachine = atmMachine;
        this.card = card;
        checkBalance();
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + card.getBankAccount().getBalance());
        atmMachine.setATMState(new IdleState(atmMachine));
    }
}
