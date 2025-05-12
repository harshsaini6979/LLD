package CricBuzzDesign.Player;

import CricBuzzDesign.MatchType;

import java.util.Map;

public class Player {
    int playerNo;
    String playerName;
    String playerInfo;
    String battingStyle;
    String bowlingStyle;
    Map<MatchType, BattingProfile> battingProfileMap;
    Map<MatchType, BowlingProfile> bowlingProfileMap;

    public Player(int playerNo, String playerName, String playerInfo, String battingStyle, String bowlingStyle,
                  Map<MatchType, BattingProfile> battingProfileMap,
                  Map<MatchType, BowlingProfile> bowlingProfileMap) {
        this.playerNo = playerNo;
        this.playerName = playerName;
        this.playerInfo = playerInfo;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
        this.battingProfileMap = battingProfileMap;
        this.bowlingProfileMap = bowlingProfileMap;
    }

    public int getPlayerNo() {
        return this.playerNo;
    }

    public String getName () {
        return playerName;
    }

    public String toString() {
        return "Player{" +
                "playerNo=" + playerNo +
                ", playerName='" + playerName + '\'' +
                ", playerInfo='" + playerInfo + '\'' +
                ", battingStyle='" + battingStyle + '\'' +
                ", bowlingStyle='" + bowlingStyle +
                '}';
    }

    public void printProfile() {
        System.out.println("Player No: " + playerNo);
        System.out.println("Player Name: " + playerName);
        System.out.println("Player Info: " + playerInfo);
        System.out.println("Batting Style: " + battingStyle);
        System.out.println("Bowling Style: " + bowlingStyle);

        System.out.println("Batting Profile: ");
        for (Map.Entry<MatchType, BattingProfile> entry : battingProfileMap.entrySet()) {
            BattingProfile battingProfile = entry.getValue();
            System.out.println(battingProfile.toString());
        }

        System.out.println("Bowling Profile: ");
        for (Map.Entry<MatchType, BowlingProfile> entry : bowlingProfileMap.entrySet()) {
            BowlingProfile bowlingProfile = entry.getValue();
            System.out.println(bowlingProfile.toString());
        }
    }

    public BattingProfile getBattingProfile(MatchType matchType) {
        return battingProfileMap.get(matchType);
    }

    public BowlingProfile getBowlingProfile(MatchType matchType) {
        return bowlingProfileMap.get(matchType);
    }
}
