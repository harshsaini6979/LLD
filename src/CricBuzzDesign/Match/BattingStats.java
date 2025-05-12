package CricBuzzDesign.Match;

public class BattingStats {
    public int balls;
    public int runs;
    public int fours;
    public int sixes;

    public BattingStats() {
        this.balls = 0;
        this.runs = 0;
        this.fours = 0;
        this.sixes = 0;
    }

    public void updateBattingScore(int runs) {
        this.runs += runs;
        this.balls++;
        if (runs == 4) {
            this.fours++;
        } else if (runs == 6) {
            this.sixes++;
        }
    }

    public String toString() {
        return "[Runs: " + runs + ", Balls: " + balls + ", Fours: " + fours + ", Sixes: " + sixes + "]";
    }
}
