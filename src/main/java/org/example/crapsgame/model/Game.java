package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    // Getters
    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        return this.shootCount;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean isWin() {
        return this.win;
    }

    public boolean isLose() {
        return this.lose;
    }

    // Roll the dices and calculate the result
    public int rollDices() {
        int roll1 = dice1.rollDice();
        int roll2 = dice2.rollDice();
        this.shoot = roll1 + roll2;
        this.shootCount++;
        evaluateRoll();
        return this.shoot;
    }

    // Evaluate the roll according to the rules of Craps
    private void evaluateRoll() {
        if (shootCount == 1) {
            // First roll
            if (shoot == 7 || shoot == 11) {
                this.win = true;
            } else if (shoot == 2 || shoot == 3 || shoot == 12) {
                this.lose = true;
            } else {
                this.point = shoot; // Set the point for future rolls
            }
        } else {
            // Subsequent rolls
            if (shoot == point) {
                this.win = true; // Win by hitting the point
            } else if (shoot == 7) {
                this.lose = true; // Lose by rolling a 7 before hitting the point
            }
        }
    }
}
