package ATMDesign.Notes;

public class FiveHNotes extends Notes{
    int domination = 500;
    int count;

    public FiveHNotes(Notes notes) {
        super(notes);
    }

    public FiveHNotes(Notes notes, int count) {
        super(notes, count);
        this.count = count;
    }

    @Override
    public boolean withdraw(int amount) {
        int userCount = 0;
        while (amount >= domination && count>0) {
            amount -= domination;
            count--;
            userCount++;
        }

        boolean returnedValue = false;

        if (amount == 0)
            returnedValue = true;

        if (!returnedValue && nextNotes != null) {
            returnedValue = nextNotes.withdraw(amount);
        }

        if (returnedValue && userCount > 0)
            System.out.println("500 notes:  " + userCount);

        return returnedValue;
    }

}
