package com.bridgelabz.javaproject;

import java.util.Random;

public class Snake_Ladder {

    static int playerOnePosition = 0;
    static int playerTwoPosition = 0;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int PLAYER1 = 1;
    static final int PLAYER2 = 2;
    static final int WINNING_POS = 100;
    static int player = PLAYER1;
    static int dicePlayerOneCount = 0;
    static int dicePlayerTwoCount = 0;
    static int optionPlayerOne;
    static int optionPlayerTwo;
    static int option = 0;
    static int dice;

    public static int diceRoll() {
        Random random = new Random();
        int dice = random.nextInt(6) + 1;
        return dice;
    }

    public static int optionCheck(int dice, int position) {
        Random random = new Random();
        int option = random.nextInt(3);

        return option;
    }

    public static void playerPlayCheck(int option) {
        if (player == PLAYER1) {
            if ((option == SNAKE) || (option == NO_PLAY)) {
                player = PLAYER2;
            }
        } else if (player == PLAYER2) {
            if ((option == SNAKE) || (option == NO_PLAY)) {
                player = PLAYER1;
            }
        }
    }

    public static void positionCheck(int option, int position, int dice) {
        if ((option == LADDER) && (position + dice <= WINNING_POS)) {
            position += dice;
        } else if (option == SNAKE) {
            position -= dice;
        } else {
            position = position;
        }
        if (position < 0) {
            position = 0;
        }
        if (player == PLAYER1) {
            playerOnePosition = position;
        } else if (player == PLAYER2) {
            playerTwoPosition = position;
        }
    }

    public static void playerDiceCount() {
        if (player == PLAYER1) {
            optionPlayerOne = optionCheck(dice, playerOnePosition);
            positionCheck(optionPlayerOne, playerOnePosition, dice);
            option = optionPlayerOne;
            dicePlayerOneCount++;
        } else if (player == PLAYER2) {
            optionPlayerTwo = optionCheck(dice, playerTwoPosition);
            positionCheck(optionPlayerTwo, playerTwoPosition, dice);
            option = optionPlayerTwo;
            dicePlayerTwoCount++;
        }

    }

    public static void playerWinStatus() {
        if (playerOnePosition == WINNING_POS) {
            System.out.println("Player One Wins");
        } else {
            System.out.println("Player Two Wins");
        }
    }

    public static void main(String[] args) {

        while (playerOnePosition < WINNING_POS && playerTwoPosition < WINNING_POS) {
            dice = diceRoll();
            playerPlayCheck(option);
            playerDiceCount();

        }
        System.out.println("playerOnePosition = " + playerOnePosition + "\nplayerTwoPosition = " + playerTwoPosition);

        System.out
                .println("dicePlayerOneCount = " + dicePlayerOneCount + "\ndicePlayerTwoCount = " + dicePlayerTwoCount);
        playerWinStatus();

    }

}