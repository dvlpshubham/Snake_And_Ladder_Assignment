package com.bridgelabz.javaproject;

import java.util.Random;

public class Snake_Ladder {

    static int position = 0;

    public static int diceRoll() {
        Random random = new Random();
        int dice = random.nextInt(6) + 1;
        return dice;
    }

    public static void main(String[] args) {
        System.out.println("dice= " + diceRoll());

    }

}