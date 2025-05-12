package CricBuzzDesign.Match.Game;

import CricBuzzDesign.Match.BattingStats;
import CricBuzzDesign.Match.BowlingStats;
import CricBuzzDesign.Match.Game.MatchStrategy.MatchStrategy;
import CricBuzzDesign.Match.Game.MatchStrategy.OneDayGame;
import CricBuzzDesign.Match.Game.MatchStrategy.T20Game;
import CricBuzzDesign.Match.Game.MatchStrategy.TestGame;
import CricBuzzDesign.Match.ScoreCard;
import CricBuzzDesign.Match.TeamStats;
import CricBuzzDesign.MatchType;
import CricBuzzDesign.Player.Player;
import CricBuzzDesign.Team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Team team1;
    Team team2;
    String winner;

    List<Player> playingTeam1;
    List<Player> playingTeam2;
    ScoreCard scoreCard;
    MatchType matchType;
    MatchStrategy matchStrategy;

    public Game(Team team1, Team team2, MatchType matchType) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchType = matchType;

        if (matchType == MatchType.TEST) {
            matchStrategy = new TestGame();
        } else if (matchType == MatchType.ONEDAY) {
            matchStrategy = new OneDayGame();
        } else if (matchType == MatchType.T20) {
            matchStrategy = new T20Game();
        }
    }

    public void play() {
        playingTeam1 = new ArrayList<>();
        playingTeam2 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        if (team1.getPlayers().size()<11 || team2.getPlayers().size()<11) {
            System.out.println("Not enough players in one of the teams");
            return;
        }

        if (team1.getPlayers().size() == 11 || team2.getPlayers().size() == 11) {
            for (Player player : team1.getPlayers()) {
                playingTeam1.add(player);
            }

            for (Player player : team2.getPlayers()) {
                playingTeam2.add(player);
            }
        }
        else {
            System.out.println("Select Team 1: ");
            System.out.println(team1.toString());
            System.out.println("Select IDs (comma separated): ");
            String input = scanner.nextLine();
            String[] ids = input.split(",");

            for (String id : ids) {
                int playerId = Integer.parseInt(id.trim());

                Player player = team1.getPlayer(playerId);

                if (player != null)
                    playingTeam1.add(team1.getPlayer(playerId));
            }

            if (playingTeam1.size() != 11) {
                System.out.println("Please select 11 players");
                return;
            }

            System.out.println("Select Team 2: ");
            System.out.println(team2.toString());
            System.out.println("Select IDs (comma separated): ");
            input = scanner.nextLine();
            ids = input.split(",");

            for (String id : ids) {
                int playerId = Integer.parseInt(id.trim());

                Player player = team2.getPlayer(playerId);

                if (player != null)
                    playingTeam2.add(team2.getPlayer(playerId));
            }

            if (playingTeam2.size() != 11) {
                System.out.println("Please select 11 players");
                return;
            }
        }

        scoreCard = new ScoreCard(team1.getTeamName(), playingTeam1, team2.getTeamName(), playingTeam2);

        toss();
    }
    public void toss() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Toss: ");

        //generate random number between 1 and 2
        int choice = (int) (Math.random() * 2) + 1;

        if (choice == 1) {
            System.out.println("Team 1 wins the toss");
            System.out.println("Select to bat or bowl: ");
            System.out.println("1. Bat");
            System.out.println("2. Bowl");
            System.out.print("Enter choice: ");
            int choice2 = scanner.nextInt();

            if (choice2 == 1) {
                inngs1(team1.getTeamName(), team2.getTeamName());
            } else {
                inngs1(team2.getTeamName(), team1.getTeamName());
            }
        } else {
            System.out.println("Team 2 wins the toss");
            System.out.println("Select to bat or bowl: ");
            System.out.println("1. Bat");
            System.out.println("2. Bowl");
            System.out.print("Enter choice: ");
            int choice2 = scanner.nextInt();
            if (choice2 == 1) {
                inngs1(team2.getTeamName(), team1.getTeamName());
            } else {
                inngs1(team1.getTeamName(), team2.getTeamName());
            }
        }
    };

    public void inngs1(String battingTeam, String bowlingTeam) {
        matchStrategy.play(battingTeam, bowlingTeam, scoreCard);
        matchStrategy.play(bowlingTeam, battingTeam, scoreCard);

        System.out.println("Match Completed");
        displayScoreCard();

        endGame();
    }

    public void endGame() {
        TeamStats teamStats1 = scoreCard.getTeamStats(team1.getTeamName());
        TeamStats teamStats2 = scoreCard.getTeamStats(team2.getTeamName());

        if (teamStats1.teamScore > teamStats2.teamScore)
            winner = "Winner is: " + team1.getTeamName();
        else if (teamStats1.teamScore < teamStats2.teamScore)
            winner = "Winner is: " + team2.getTeamName();
        else
            winner = "Match was Drawn";

        System.out.println(winner);

        for (Player player : playingTeam1) {

            BattingStats battingStats = teamStats1.getBattingStats(player);
            player.getBattingProfile(matchType).updateBattingScore(battingStats.runs, battingStats.balls,
                    battingStats.fours, battingStats.sixes);

            BowlingStats bowlingStats = teamStats1.getBowlingStats(player);
            player.getBowlingProfile(matchType).updateBowlingScore(bowlingStats.balls, bowlingStats.runs,
                    bowlingStats.wickets);
        }

        for (Player player : playingTeam2) {

            BattingStats battingStats = teamStats2.getBattingStats(player);
            player.getBattingProfile(matchType).updateBattingScore(battingStats.runs, battingStats.balls,
                    battingStats.fours, battingStats.sixes);

            BowlingStats bowlingStats = teamStats2.getBowlingStats(player);
            player.getBowlingProfile(matchType).updateBowlingScore(bowlingStats.balls, bowlingStats.runs,
                    bowlingStats.wickets);
        }
    }

    public void displayScoreCard() {
        scoreCard.printScoreCard();
    }
}
