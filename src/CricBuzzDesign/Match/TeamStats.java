package CricBuzzDesign.Match;

import CricBuzzDesign.Player.Player;
import CricBuzzDesign.WicketType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamStats {
    String teamName;
    public Map<Player, BattingStats> battingStatsMap;
    public Map<Player, BowlingStats> bowlingStatsMap;
    public int teamScore;
    public int teamWickets;

    public TeamStats(String teamName, List<Player>  players) {
        this.teamName = teamName;

        battingStatsMap = new HashMap<>();
        bowlingStatsMap = new HashMap<>();

        for (Player player : players) {
            battingStatsMap.put(player, new BattingStats());
            bowlingStatsMap.put(player, new BowlingStats());
        }
    }
    
    public boolean updateTeamScore(Player batter, Player bowler, int runs, int wicket, WicketType wicketType, boolean isExtra) {
        if (batter!=null){
            this.teamScore += runs;
            this.teamWickets += wicket;

            if (!isExtra) {
                updateBattingScore(batter, runs);
            }
            return true;
        }
        else if (bowler!=null) {
            if (wicketType!=null && wicketType != WicketType.RUNOUT) {
                updateBowlingScore(bowler, runs, 1);
            }
            else {
                updateBowlingScore(bowler, runs, 0);
            }

            if (this.teamWickets >= 10)
                return false;
        }

        return true;
    }

    public void updateBattingScore(Player player, int runs) {
        battingStatsMap.get(player).updateBattingScore(runs);
    }

    public void updateBowlingScore(Player player, int runs, int wickets) {
        bowlingStatsMap.get(player).updateBowlingScore(runs, wickets);
    }

    public String toStringBatting() {
        StringBuilder sb = new StringBuilder();
        sb.append("Batting Name: " ).append(teamName).append("\n");
        sb.append("Team Score: ").append(teamScore).append("\n");
        sb.append("Team Wickets: ").append(teamWickets).append("\n");
        sb.append("Batting Stats: \n");

        for (Map.Entry<Player, BattingStats> entry : battingStatsMap.entrySet()) {
            Player key = entry.getKey();
            BattingStats value = entry.getValue();

            if (value.balls > 0) {
                sb.append(key.getName()).append(": ").append(value.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String toStringBowling() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bowling Name: " ).append(teamName).append("\n");

        sb.append("Bowling Stats: \n");
        for (Map.Entry<Player, BowlingStats> entry : bowlingStatsMap.entrySet()) {
            Player key = entry.getKey();
            BowlingStats value = entry.getValue();

            if (value.balls > 0) {
                sb.append(key.getName()).append(": ").append(value.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public BattingStats getBattingStats(Player player) {
        return battingStatsMap.get(player);
    }

    public BowlingStats getBowlingStats(Player player) {
        return bowlingStatsMap.get(player);
    }

    public TeamStats getTeamStats() {
        return this;
    }

    public List<Player> getPlayers() {
        return battingStatsMap.keySet().stream().toList();
    }
}
