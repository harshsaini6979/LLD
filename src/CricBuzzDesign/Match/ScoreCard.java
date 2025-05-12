package CricBuzzDesign.Match;

import CricBuzzDesign.Player.Player;

import java.util.List;

public class ScoreCard {
    TeamStats team1;
    TeamStats team2;

    public ScoreCard(String team1Name, List<Player> playingTeam1, String team2Name, List<Player> playingTeam2) {
        this.team1 = new TeamStats(team1Name, playingTeam1);
        this.team2 = new TeamStats(team2Name, playingTeam2);
    }

    public void printScoreCard() {
        System.out.println("Score Card");

        System.out.println("Innings 1");

        System.out.println(team1.toStringBatting());
        System.out.println(team2.toStringBowling());

        System.out.println("Innings 2");
        System.out.println(team2.toStringBatting());
        System.out.println(team1.toStringBowling());
    }

    public TeamStats getTeamStats(String teamName) {
        if (team1.teamName.equals(teamName)) {
            return team1;
        } else if (team2.teamName.equals(teamName)) {
            return team2;
        } else {
            System.out.println("Invalid team name");
            return null;
        }
    }
}
