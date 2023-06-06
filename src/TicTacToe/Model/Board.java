package TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;

    public PlayerPiece [][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayerPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayerPiece playerPiece){
        if (row<0 || row>=size || col<0 || col>=size)
            return false;
        if (board[row][col] != null)
            return false;
        board[row][col] = playerPiece;

        return true;
    }

    public List<List<Integer>> getFreeCells() {
        List<List<Integer>> freeCells = new ArrayList<>();

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j] == null){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    freeCells.add(temp);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size-1; j++) {
                if (board[i][j] == null)
                    System.out.print("   " + "|");
                else
                    System.out.print(" " + board[i][j].pieceType.toString() + " " + "|");
            }
            if (board[i][size-1] == null)
                System.out.println("   ");
            else
                System.out.println(" " + board[i][size-1].pieceType.toString() + " ");
        }
    }

}
