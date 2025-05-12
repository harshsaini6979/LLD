package CricBuzzDesign.Player;

import CricBuzzDesign.MatchType;

public class BattingProfile {
    MatchType matchType;
    int runs;
    int ballsFaced;
    int fours;
    int sixes;
    int fifties;
    int hundreds;

    public BattingProfile(MatchType matchType, int runs, int ballsFaced, int fours, int sixes, int fifties, int hundreds) {
        this.matchType = matchType;
        this.runs = runs;
        this.ballsFaced = ballsFaced;
        this.fours = fours;
        this.sixes = sixes;
        this.fifties = fifties;
        this.hundreds = hundreds;
    }

    public String toString() {
        return "Match Type: " + matchType + "\t" +
               "Runs: " + runs + "\t" +
               "Balls Faced: " + ballsFaced + "\t" +
               "Fours: " + fours + "\t" +
               "Sixes: " + sixes + "\t" +
               "Fifties: " + fifties + "\t" +
               "Hundreds: " + hundreds;
    }

    public void updateBattingScore(int runs, int ballsFaced, int fours, int sixes) {
        this.runs += runs;
        this.ballsFaced += ballsFaced;
        this.fours += fours;
        this.sixes += sixes;

        if (runs >= 50)
            fifties++;
        else if (runs >= 100)
            hundreds++;
    }
}
