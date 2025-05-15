package CricBuzzDesign.Match.Game.MatchStrategy;

import CricBuzzDesign.Match.ScoreCard;
import CricBuzzDesign.Match.TeamStats;
import CricBuzzDesign.Player.Player;
import CricBuzzDesign.WicketType;

import java.util.ArrayList;
import java.util.List;

public class T20Game implements MatchStrategy {
    int overs = 20;
    @Override
    public void play(String battingTeam, String bowlingTeam, ScoreCard scoreCard) {
        TeamStats battingTeamStats = scoreCard.getTeamStats(battingTeam);
        TeamStats bowlingTeamStats = scoreCard.getTeamStats(bowlingTeam);

        Player batter1 = battingTeamStats.getPlayers().get(0);
        Player batter2 = battingTeamStats.getPlayers().get(1);

        int batterIndex = 2;

        List<Player> availableBowlers = new ArrayList<>();

        for (Player player : bowlingTeamStats.getPlayers().subList(3, 10)) {
            availableBowlers.add(player);
        }

        Player bowler = availableBowlers.get(0);
        int bowlerIndex = 0;

        boolean toContinue = true;
        int i = 0;
        while (toContinue && i++ < overs*6) {
            try {
                int extras = (int) (Math.random() * 20);

                if (extras == 1) {
                    toContinue = battingTeamStats.updateTeamScore(batter1, null, 1, 0, null, true);
                    i--;
                    continue;
                }

                int runs = (int) (Math.random() * 7);

                int wicket = (int) (Math.random() * 80);

                if (wicket == 1) {
                    runs = 0;
                    toContinue = bowlingTeamStats.updateTeamScore(null, bowler, runs, 0, WicketType.CAUGHTOUT, false);
                    toContinue = battingTeamStats.updateTeamScore(batter1, null, runs, 1, WicketType.CAUGHTOUT, false);
                    batter1 = battingTeamStats.getPlayers().get(batterIndex++);
                    continue;
                } else if (wicket == 21) {
                    runs = 0;
                    toContinue = bowlingTeamStats.updateTeamScore(null, bowler, runs, 0, WicketType.LBW, false);
                    toContinue = battingTeamStats.updateTeamScore(batter1, null, runs, 1, WicketType.LBW, false);
                    batter1 = battingTeamStats.getPlayers().get(batterIndex++);
                    continue;
                } else if (wicket == 41) {
                    runs = 0;
                    toContinue = bowlingTeamStats.updateTeamScore(null, bowler, runs, 0, WicketType.RUNOUT, false);
                    toContinue = battingTeamStats.updateTeamScore(batter1, null, runs, 1, WicketType.RUNOUT, false);
                    batter1 = battingTeamStats.getPlayers().get(batterIndex++);
                    continue;
                } else if (wicket == 61) {
                    runs = 0;
                    toContinue = bowlingTeamStats.updateTeamScore(null, bowler, runs, 0, WicketType.STUMPED, false);
                    toContinue = battingTeamStats.updateTeamScore(batter1, null, runs, 1, WicketType.STUMPED, false);
                    batter1 = battingTeamStats.getPlayers().get(batterIndex++);
                    continue;
                }

                toContinue = bowlingTeamStats.updateTeamScore(null, bowler, runs, 0, null, false);
                toContinue = battingTeamStats.updateTeamScore(batter1, null, runs, 0, null, false);

                if (runs == 1 || runs == 3 || runs == 5 || i%6==0) {
                    Player temp = batter1;
                    batter1 = batter2;
                    batter2 = temp;
                }

                if (i % 6 == 0) {
                    if (bowlingTeamStats.getBowlingStats(bowler).balls >= 6*4){
                        System.out.println("Yes");
                        availableBowlers.remove(bowlerIndex);
                    }

                    bowlerIndex = (int) (Math.random() * availableBowlers.size());
                    bowler = availableBowlers.get(bowlerIndex);

                    Player temp = batter1;
                    batter1 = batter2;
                    batter2 = temp;
                }
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
                break;
            }
        }

    }
}
