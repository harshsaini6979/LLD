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
        String toReturn = "";
        int diff = 5;

        int i = diff;

        String overs = "";
        overs = String.valueOf(balls/6);

        if (balls%6 != 0) {
            overs += "." + String.valueOf(balls%6);
        }

        toReturn += String.valueOf(overs);
        i -= overs.length();
        while (i-- > 0) {
            toReturn += " ";
        }

        toReturn += "0";
        for (int j = 0; j < diff - 1; j++) {
            toReturn += " ";
        }

        toReturn += String.valueOf(runs);

        i = diff;
        i -= String.valueOf(runs).length();
        while (i-- > 0) {
            toReturn += " ";
        }

        toReturn += String.valueOf(wickets);
        i = diff;
        i -= String.valueOf(wickets).length();
        while (i-- > 0) {
            toReturn += " ";
        }

        double economy = balls > 0 ? (runs * 6.0) / balls : 0.0;
        toReturn += String.format("%.2f", economy);

        return toReturn;
    }
}
