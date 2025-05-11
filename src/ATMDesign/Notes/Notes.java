package ATMDesign.Notes;

public abstract class Notes {
    protected Notes nextNotes;
    protected int count;

    public Notes(Notes nextNotes, int count) {
        this.nextNotes = nextNotes;
        this.count = count;
    }

    public Notes(Notes nextNotes) {
        this.nextNotes = nextNotes;
    }

    public boolean withdraw(int amount) {
        if (nextNotes != null) {
            nextNotes.withdraw(amount);
        }

        return false;
    }
}
