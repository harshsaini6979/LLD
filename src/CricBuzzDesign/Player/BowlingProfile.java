package CricBuzzDesign.Player;

import CricBuzzDesign.MatchType;

public class BowlingProfile {
    MatchType matchType;
    int ballsBowled;
    int runsConceded;
    int wickets;
    int fiveWicketHaul;

    public BowlingProfile(MatchType matchType, int ballsBowled, int runsConceded, int wickets, int fiveWicketHaul) {
        this.matchType = matchType;
        this.ballsBowled = ballsBowled;
        this.runsConceded = runsConceded;
        this.wickets = wickets;
        this.fiveWicketHaul = fiveWicketHaul;
    }

    public String toString() {
        return "Match Type: " + matchType + "\t" +
               "Balls Bowled: " + ballsBowled + "\t" +
               "Runs Conceded: " + runsConceded + "\t" +
               "Wickets: " + wickets + "\t" +
               "Five Wicket Haul: " + fiveWicketHaul;
    }

    public void updateBowlingScore(int ballsBowled, int runsConceded, int wickets) {
        this.ballsBowled += ballsBowled;
        this.runsConceded += runsConceded;
        this.wickets += wickets;

        if (wickets >= 5)
            fiveWicketHaul++;
    }
}
