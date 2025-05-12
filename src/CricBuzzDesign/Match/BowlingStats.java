package CricBuzzDesign.Match;

public class BowlingStats {
    public int balls;
    public int runs;
    public int wickets;

    public BowlingStats() {
        balls = 0;
        runs = 0;
    }

    public void updateBowlingScore(int runs, int wickets) {
        this.balls++;
        this.runs += runs;
        this.wickets += wickets;
    }

    public String toString() {
        return "[" +
                "Balls=" + balls +
                ", Runs=" + runs +
                ", Wickets=" + wickets +
                "]";
    }
}
