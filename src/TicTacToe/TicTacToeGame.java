package TicTacToe;

import TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Board board;
    Deque<Player> playerList;

    public TicTacToeGame() {
        initialiseGame();
    }

    public void initialiseGame() {
        board = new Board(3);

        playerList = new LinkedList<>();
        PlayerPieceX crossPiece = new PlayerPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayerPieceO noughtsPiece = new PlayerPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        playerList.add(player1);
        playerList.add(player2);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner){

            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = playerList.removeFirst();

            //get the free space from the board
            board.printBoard();
            List<List<Integer>> freeSpaces =  board.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            //read the user input
            System.out.print("Player:" + playerTurn.playerName + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);


            //place the piece
            boolean pieceAddedSuccessfully = board.addPiece(inputRow,inputColumn, playerTurn.playerPiece);
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position chosen, try again");
                playerList.addFirst(playerTurn);
                continue;
            }
            playerList.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playerPiece.pieceType);
            if(winner) {
                board.printBoard();
                return playerTurn.playerName;
            }
        }

        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.size;i++) {

            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.size;i++) {

            if(board.board[i][column] == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}