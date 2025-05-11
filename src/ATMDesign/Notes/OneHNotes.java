package ATMDesign.Notes;

public class OneHNotes extends Notes{
    int domination = 100;
    int count;
    public OneHNotes(Notes notes) {
        super(notes);
    }

    public OneHNotes(Notes notes, int count) {
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
            System.out.println("100 notes:  " + userCount);

        return returnedValue;
    }

}
