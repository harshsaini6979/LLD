package TicTacToe.Model;

public class Player {
    public String playerName;
    public PlayerPiece playerPiece;

    public Player(String playerName, PlayerPiece playerPiece) {
        this.playerName = playerName;
        this.playerPiece = playerPiece;
    }
}
