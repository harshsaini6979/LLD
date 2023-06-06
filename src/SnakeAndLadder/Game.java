package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner = null;

    public Game() {
        initialiseGame();
    }

    private void initialiseGame() {
        board = new Board(10, 4, 5);
        dice = new Dice(1);
        addPlayers();
    }

    private void addPlayers() {
        Player p1 = new Player("p1", 0);
        Player p2 = new Player("p2", 0);

        playerList.add(p1);
        playerList.add(p2);
    }

    public void startGame() {
        while (winner==null) {
            Player turn = findTurn();

            System.out.println("Current turn is of player: " + turn.id + " Current position is: " + turn.currPos);
            int roll = dice.rollDice();
            int nextPos = turn.currPos + roll;
            nextPos = jumpCheck(nextPos);

            System.out.println("Dice rolled up: " + roll);

            if (nextPos == board.size*board.size-1) {
                winner = turn;
                System.out.println("!!!! Player " + turn.id + " has won the game !!!!");
            }
            else if (nextPos < board.size*board.size-1) {
                turn.currPos = nextPos;
                System.out.println("New position of player " + turn.id + " is " + turn.currPos);
            }
            else {
                System.out.println("New position of player " + turn.id + " is " + turn.currPos);
            }
        }
    }

    private Player findTurn() {
        Player removedPlayer = playerList.removeFirst();
        playerList.add(removedPlayer);
        return removedPlayer;
    }

    private int jumpCheck(int pos) {
        if (pos > board.size*board.size-1)
            return pos;

        Cell cell = board.getCell(pos);

        if(cell.jump!=null && cell.jump.start==pos) {
            String jumpBy = (cell.jump.start<cell.jump.end) ? "ladder" : "snake";
            System.out.println("Jump done by: " + jumpBy);
            return cell.jump.end;
        }

        return pos;
    }
}
