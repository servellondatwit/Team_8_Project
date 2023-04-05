package wit.comp1050;

import java.util.*;
import java.awt.Color;

import static java.awt.Color.*;

import java.util.concurrent.ThreadLocalRandom;

public class Mastermind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Color[] Colors = {RED, BLUE, GREEN, MAGENTA, BLACK,
                WHITE, YELLOW, ORANGE, CYAN};

        int[] Num = {0, 1, 2, 3, 4, 5, 6, 7};

        Code solution = new Code(Num);
        Color[] gameColor = new Color[6];

        for (int i = 0; i < Num.length; i++) {
            gameColor[i] = Colors[Num[i]];
        }
        for (int i = 0; i < Num.length; i++) {
            System.out.print(gameColor[i] + " ");
        }
        System.out.println();


        static int Code (int[] ar){
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }


            //TODO: Make this work
            System.out.print("Please select your Difficulty (NOVICE, BEGINNER, INTERMEDIATE, EXPERT):");
            String difficulty = scanner.nextLine();
            try {
                var enumValue = Difficulty.valueOf(difficulty);
                System.out.printf("Welcome to Mastermind you have selected %s%n", difficulty);
                break;

            } catch (IllegalArgumentException ex) {
                System.out.println("Please select a listed Difficulty");
                continue;

            }
            Difficulty theDifficulty = switch (difficulty) {
                case "Novice" -> Difficulty.NOVICE;
                case "Beginner" -> Difficulty.BEGINNER;
                case "Intermediate" -> Difficulty.INTERMEDIATE;
                case "Expert" -> Difficulty.EXPERT;
                default -> throw new IllegalArgumentException("Please select a valid Difficulty!");
            };
        }
        while (true) ;
        System.out.println("Please make your first guess!");

        Code secret = new Code(gameColor);

        boolean continuetoPlay = true;
        do {
            System.out.print("Guess a code (no duplicate colors): ");
            String[] currentGuess = new String[6];
            for (int i = currentGuess.length; i < 0; i++) {
                System.out.print("What is the next color of your guess?");
                currentGuess[i] = scanner.next();
            }

            if (currentGuess.equals(secret.getCode())) {
                System.out.println("You win!");
                continuetoPlay = false;
            } else {
                int[] excessCounter = new int[secret.numofColors]
                for (int i = 0; i < currentGuess.length; i++) {
                    if (currentGuess.getCode()[i] == secret.getCode()[i]) {
                        correctColorAndPos++;
                    }
                    else {
                        excessCounter[currentGuess.getCode()[i]]++;
                        unusedSolutionCounter[secret.getCode()[i]++];
                    }
                }
                // compute the score -# of white pegs and # of black pegs
                //print score
                //loop
            }
            while {
                (continuetoPlay);

                private String correctColorAndPos = "Correct Color and Pos: ";
                private String correctColorWrongPos = "Correct Color Wrong Pos: ";
                private int correctColorWrongPos = 0;
                private int correctColorAndPos = 0;
            }
        }
    }
}
