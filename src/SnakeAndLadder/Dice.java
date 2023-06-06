package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min;
    int max;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
        this.min = 1;
        this.max = 6;
    }

    int rollDice() {
        int currDice = 0;
        int rollVal = 0;

        while(currDice++ < this.diceCount) {
            int temp = ThreadLocalRandom.current().nextInt(min,max+1);
            rollVal += temp;
        }

        return rollVal;
    }
}
