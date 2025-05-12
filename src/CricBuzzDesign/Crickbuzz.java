package CricBuzzDesign;

import CricBuzzDesign.Match.Game.Game;
import CricBuzzDesign.Player.BattingProfile;
import CricBuzzDesign.Player.BowlingProfile;
import CricBuzzDesign.Player.Player;
import CricBuzzDesign.Team.Team;

import java.util.*;

public class Crickbuzz {

    static Map<Integer, Player> playerList;
    static Map<String, Team> teamList;
    static List<Game> gameList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        playerList = getPlayerList();
        teamList = getTeamList();

        while (true) {
            System.out.println("1. Add Player");
            System.out.println("2. Add Team");
            System.out.println("3. Print Player");
            System.out.println("4. Print Team");
            System.out.println("5. Play Game");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.print("Enter Player Number: ");
                    int playerNumber = Integer.parseInt(scanner.nextLine());

                    if (playerList.containsKey(playerNumber)) {
                        System.out.println("Player already exists");
                        break;
                    }

                    System.out.print("Enter Player Name: ");
                    String playerName = scanner.nextLine();
                    System.out.print("Enter Player Info: ");
                    String playerInfo = scanner.nextLine();
                    System.out.print("Enter Batting Style: ");
                    String battingStyle = scanner.nextLine();
                    System.out.print("Enter Bowling Style: ");
                    String bowlingStyle = scanner.nextLine();

                    Map<MatchType, BattingProfile> battingProfileMap = new HashMap<>();
                    Map<MatchType, BowlingProfile> bowlingProfileMap = new HashMap<>();

                    battingProfileMap.put(MatchType.TEST, new BattingProfile(MatchType.TEST, 0,0, 0,0,0,0));
                    battingProfileMap.put(MatchType.ONEDAY, new BattingProfile(MatchType.ONEDAY, 0,0, 0,0,0,0));
                    battingProfileMap.put(MatchType.T20, new BattingProfile(MatchType.T20, 0,0, 0,0,0,0));

                    bowlingProfileMap.put(MatchType.TEST, new BowlingProfile(MatchType.TEST, 0,0, 0,0));
                    bowlingProfileMap.put(MatchType.ONEDAY, new BowlingProfile(MatchType.ONEDAY, 0,0, 0,0));
                    bowlingProfileMap.put(MatchType.T20, new BowlingProfile(MatchType.T20, 0,0, 0,0));
                    Player player = new Player(playerNumber, playerName, playerInfo, battingStyle, bowlingStyle, battingProfileMap, bowlingProfileMap);
                    playerList.put(player.getPlayerNo(), player);
                    break;
                case 2:
                    System.out.print("Enter Team Name: ");
                    String teamName = scanner.nextLine();

                    if (teamList.containsKey(teamName)) {
                        System.out.println("Team already exists");
                        break;
                    }

                    System.out.println("Enter Player IDs (comma separated)");
                    String playerIds = scanner.nextLine();
                    List<Player> players = new ArrayList<>();

                    String[] ids = playerIds.split(",");

                    for (String id : ids) {
                        int playerId = Integer.parseInt(id.trim());
                        Player p = playerList.get(playerId);

                        if (p != null) {
                            players.add(p);
                        }
                    }
                    Team team = new Team(teamName, players);
                    teamList.put(team.getTeamName(), team);
                    break;
                case 3:
                    System.out.print("Enter Player Number: ");
                    int playerId = Integer.parseInt(scanner.nextLine());
                    Player p = playerList.get(playerId);
                    if (p != null) {
                        p.printProfile();
                    } else {
                        System.out.println("Player not found");
                    }
                    break;
                case 4:
                    System.out.print("Enter Team Name: ");
                    String teamToPrint = scanner.nextLine();
                    Team t = teamList.get(teamToPrint);
                    if (t != null) {
                        System.out.println(t.toString());
                    } else {
                        System.out.println("Team not found");
                    }
                    break;
                case 5:
                    System.out.print("Enter Team 1 Name: ");
                    String team1Name = scanner.nextLine();
                    System.out.print("Enter Team 2 Name: ");
                    String team2Name = scanner.nextLine();
                    System.out.print("Enter Match Type (TEST/ONEDAY/T20): ");
                    String matchTypeInput = scanner.nextLine();
                    MatchType matchType = MatchType.valueOf(matchTypeInput.toUpperCase());

                    Team team1 = teamList.get(team1Name);
                    Team team2 = teamList.get(team2Name);

                    if (team1 != null && team2 != null) {
                        Game game = new Game(team1, team2, matchType);
                        game.play();
                        gameList.add(game);
                    } else {
                        System.out.println("One of the teams not found");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static Map<Integer, Player> getPlayerList() {
        Random random = new Random();
        //add 11 players
        Map<Integer, Player> playerList = new HashMap<>();


        for (int i = 1; i <= 25; i++) {
            int playerNumber = i;
            String playerName = "Player" + i;
            String playerInfo = "Info about Player" + i;
            String[] battingStyles = {"Right-Handed", "Left-Handed"};
            String[] bowlingStyles = {"Right-Arm Fast", "Left-Arm Spin", "Right-Arm Medium", "Left-Arm Fast"};
            String battingStyle = battingStyles[random.nextInt(battingStyles.length)];
            String bowlingStyle = bowlingStyles[random.nextInt(bowlingStyles.length)];

            Map<MatchType, BattingProfile> battingProfileMap = new HashMap<>();
            Map<MatchType, BowlingProfile> bowlingProfileMap = new HashMap<>();

            for (MatchType matchType : MatchType.values()) {
                int hundreds = random.nextInt(10);
                int fifties = random.nextInt(20);
                int fours = random.nextInt(200);
                int sixes = random.nextInt(100);
                int runs = Math.max(hundreds * 100 + fifties * 50 + 1, fours * 4 + sixes * 6 + 1) + random.nextInt(1500);
                int balls = runs + random.nextInt(500);

                battingProfileMap.put(matchType, new BattingProfile(matchType, runs, balls, fours, sixes, hundreds, fifties));

                int fiveWicketHauls = random.nextInt(10);
                int wickets = Math.max(5 * fiveWicketHauls + 1, random.nextInt(300));
                int ballsBowled = wickets * 6 + random.nextInt(500);
                int runsConceded = wickets * 4 + random.nextInt(1000);
                bowlingProfileMap.put(matchType, new BowlingProfile(matchType, runsConceded, ballsBowled, wickets, fiveWicketHauls));
            }
            Player player = new Player(playerNumber, playerName, playerInfo, battingStyle, bowlingStyle, battingProfileMap, bowlingProfileMap);
            playerList.put(playerNumber, player);
        }

        return playerList;
    }

    private static Map<String, Team> getTeamList() {
        Map<String, Team> teamList = new HashMap<>();
        List<Player> players1 = new ArrayList<>();
        List<Player> players2 = new ArrayList<>();

        for (int i = 1; i <= 11; i++) {
            players1.add(playerList.get(i));
        }
        for (int i = 12; i <= 22; i++) {
            players2.add(playerList.get(i));
        }

        Team team1 = new Team("Team1", players1);
        Team team2 = new Team("Team2", players2);
        teamList.put(team1.getTeamName(), team1);
        teamList.put(team2.getTeamName(), team2);
        return teamList;
    }
}
