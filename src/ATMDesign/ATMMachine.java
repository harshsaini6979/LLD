package ATMDesign;

import ATMDesign.ATMStates.ATMState;
import ATMDesign.ATMStates.IdleState;
import ATMDesign.Notes.FiveHNotes;
import ATMDesign.Notes.Notes;
import ATMDesign.Notes.OneHNotes;
import ATMDesign.Notes.TwoKNotes;

import java.util.HashMap;
import java.util.Map;

public class ATMMachine {
    ATMState atmState;
    Notes notes;
    private Map<String, Card> cardMap;

    public ATMMachine() {
        intializeATM();
    }

    public boolean withdrawCash(Card card, int amount) {
        return notes.withdraw(amount);
    }

    public ATMState getATMState() {
        return atmState;
    }

    public void setATMState(ATMState atmState) {
        this.atmState = atmState;
    }

    public Map<String, Card> getCards() {
        return cardMap;
    }

    public void intializeATM() {
        notes = new TwoKNotes(new FiveHNotes(new OneHNotes(null, 10), 10), 10);

        BankAccount bankAccount1 = new BankAccount("123", "Harsh", 1000);
        Card card1 = new Card("123", "Harsh", "12/25", "123", bankAccount1, "1234");

        BankAccount bankAccount2 = new BankAccount("456", "Raman", 900);
        Card card2 = new Card("456", "Raman", "12/25", "456", bankAccount2, "1234");

        BankAccount bankAccount3 = new BankAccount("789", "Jay", 5000);
        Card card3 = new Card("789", "Jay", "12/25", "123", bankAccount3, "1234");

        BankAccount bankAccount4 = new BankAccount("101", "Dileep", 3000);
        Card card4 = new Card("101", "Dileep", "12/25", "456", bankAccount4, "1234");

        cardMap = new HashMap<>();
        cardMap.put(card1.getCardNo(), card1);
        cardMap.put(card2.getCardNo(), card2);
        cardMap.put(card3.getCardNo(), card3);
        cardMap.put(card4.getCardNo(), card4);

        atmState = new IdleState(this);
    }
}
