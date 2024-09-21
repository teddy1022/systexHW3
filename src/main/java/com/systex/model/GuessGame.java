package com.systex.model;

public class GuessGame {
    private int remains;
    private int luckyNumber; 

    public GuessGame(int range, int remains) {
        this.remains = remains;
        this.luckyNumber = (int) (Math.random() * range) + 1; 
    }

    public boolean guess(int number) {
        if (remains > 0) {
            remains--; 
            return number == luckyNumber; 
        }
        return false;
    }

    public int getRemains() {
        return remains;
    }

    public String getHint(int number) {
        if (number > luckyNumber) {
            return "Too high! Try a smaller number.";
        } else if (number < luckyNumber) {
            return "Too low! Try a larger number.";
        } else {
            return "Correct!";
        }
    }
}
