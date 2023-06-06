package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int size;
    Cell[][] cells = new Cell[100][100];

    public Board(int size, int snakeCount, int ladderCount) {
        this.size = size;
        defineBoard(size);
        addSnakesLadder(size, snakeCount, ladderCount);
    }

    public void defineBoard(int size) {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {

                cells[i][j] = new Cell();
            }
        }
    }

    public void addSnakesLadder(int size, int snakeCount, int ladderCount) {
        while(snakeCount>0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,size*size-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,size*size-1);

            if (snakeHead < snakeTail)
                continue;

            Jump snake = new Jump();
            snake.start = snakeHead;
            snake.end = snakeTail;
            Cell cell = getCell(snakeHead);
            cell.jump = snake;

            snakeCount--;
        }

        while(ladderCount>0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, size * size - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, size * size - 1);

            if (ladderHead > ladderTail)
                continue;

            Jump ladder = new Jump();
            ladder.start = ladderHead;
            ladder.end = ladderTail;
            Cell cell = getCell(ladderHead);
            cell.jump = ladder;

            ladderCount--;
        }
    }

    public Cell getCell(int h) {
        int i = h/size;
        int j = h%size;
        return cells[i][j];
    }

}
