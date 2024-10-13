package org.example.crapsgame.model;

import org.example.crapsgame.model.Dice;

public class Game {
    private Dice dice1, dice2;
    private int shootCount;
    private int point;
    private boolean pointEstablished;

    public Game() {
        dice1 = new Dice();
        dice2 = new Dice();
        shootCount = 0;
        point = 0;
        pointEstablished = false;
    }

    public int rollDices() {
        dice1.roll();
        dice2.roll();
        shootCount++;
        int result = dice1.getValue() + dice2.getValue();

        if (!pointEstablished) {
            if (result == 7 || result == 11) {
                return 1; // Ganar
            } else if (result == 2 || result == 3 || result == 12) {
                return -1; // Perder
            } else {
                point = result;
                pointEstablished = true;
                return 0; // Punto establecido
            }
        } else {
            if (result == point) {
                return 1; // Ganar
            } else if (result == 7) {
                return -1; // Perder
            }
        }
        return 0; // Sigue jugando
    }

    public int getShootCount() {
        return shootCount;
    }

    public int getPoint() {
        return point;
    }

    public boolean isPointEstablished() {
        return pointEstablished;
    }

    public void resetGame() {
        shootCount = 0;
        point = 0;
        pointEstablished = false;
    }

    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

