package CricBuzzDesign.Team;

import CricBuzzDesign.Player.Player;

import java.util.List;

public class Team {
    String teamName;
    List<Player> players;

    public Team(String teamName, List<Player> players) {
        this.teamName = teamName;
        this.players = players;
    }

    public void addPlayer(Player player) {
        for (Player p : players) {
            if (p.getPlayerNo() == player.getPlayerNo()) {
                System.out.println("Player with the given number already exists in the team.");
                return;
            }
        }

        players.add(player);
        System.out.println("Player added successfully.");
    }

    public void removePlayer(Player player) {
        for (Player p : players) {
            if (p.getPlayerNo() == player.getPlayerNo()) {
                players.remove(p);
                System.out.println("Player removed successfully.");
                return;
            }
        }

        System.out.println("Player not found in the team.");
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getTeamName() {
        return teamName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team Name: ").append(teamName).append("\n");
        sb.append("Players: \n");
        for (Player player : players) {
            sb.append(player.toString()).append("\n");
        }
        return sb.toString();
    }

    public Player getPlayer(int playerNo) {
        for (Player player : players) {
            if (player.getPlayerNo() == playerNo) {
                return player;
            }
        }
        return null;
    }
}
