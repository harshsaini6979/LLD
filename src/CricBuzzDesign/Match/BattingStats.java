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
        String toReturn = "";

        int diff = 7;

        int i = diff;
        toReturn += String.valueOf(runs);

        i -= String.valueOf(runs).length();
        while (i-- > 0) {
            toReturn += " ";
        }

        i = diff;
        toReturn += String.valueOf(balls);

        i -= String.valueOf(balls).length();
        while (i-- > 0) {
            toReturn += " ";
        }

        i = diff;
        toReturn += String.valueOf(fours);

        i -= String.valueOf(fours).length();
        while (i-- > 0) {
            toReturn += " ";
        }

        i = diff;
        toReturn += String.valueOf(sixes);

        i -= String.valueOf(sixes).length();

        while (i-- > 0) {
            toReturn += " ";
        }


        // Calculate and format strike rate to 2 decimal places
        double strikeRate = balls > 0 ? (runs * 100.0) / balls : 0.0;
        toReturn += String.format("%.2f", strikeRate);

        return toReturn;
    }
}
