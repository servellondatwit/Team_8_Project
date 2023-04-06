package wit.comp1050;
import java.util.Random;
import java.util.*;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class Mastermind {
    //check for white pegs
    public static boolean checkWhite(int guess, int colors[]) {
        boolean test = false;
        for(int i = 0; colors.length == i; i++){
            if((colors[i]==guess) || (colors[guess]) != guess){
                test = true;
            }
            else{
                test = false;
            }
        }
        return test;
    }
    

    //for future use when we need to go from the numbers to colors for the GUI
    public static String numToColor(int num) {
        String color = ("");
        
        switch (num) {
            case 0 : {
                color = ("red");
                break;
            }
            case 1 : {
                color = ("blue");
                break;
            }
            case 2 : {
                color = ("yellow");
                break;
            }
            case 3 : {
                color = ("green");
                break;
            }
            case 4 : {
                color = ("brown");
                break;
            }
            case 5 : {
                color = ("black");
                break;
            }

        }

        return color;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] colors = {random.nextInt(5), random.nextInt(5), random.nextInt(5), random.nextInt(5)};
        boolean loop = true;

        int black = 0;
        int white = 0;
        int attemptsLeft = 6;

        //game loop
        do {
            //user display, each color has a number B represents how many black pegs you have and white the same. 
            System.out.printf("colors: red(0) | blue(1) | yellow(2) | green(3) | brown(4) | black(5) >> B:%s W:%s | Attempts Left:%s %n", black, white, attemptsLeft);
            System.out.print("choose 4 colors seperated by space: ");

            black = 0;
            white = 0;
            
            //user input
            int guess0 = scanner.nextInt();
            int guess1 = scanner.nextInt();
            int guess2 = scanner.nextInt();
            int guess3 = scanner.nextInt();
            System.out.printf("%n%n%n");
            
            //checks for the pegs, black works white still has some bugs can be made into a funciton later.
            if (guess0 == colors[0]) {
                black ++;
            } else {
                if (checkWhite(guess0, colors)){
                    white ++;
                }
            }

            if (guess1 == colors[1]) {
                black ++;
            } else {
                if (checkWhite(guess1, colors)){
                    white ++;
                }
            }
            if (guess2 == colors[2]) {
                black ++;
            } else {
                if (checkWhite(guess2, colors)){
                    white ++;
                }
            }

            if (guess3 == colors[3]) {
                black ++;
            } else {
                if (checkWhite(guess3, colors)){
                    white ++;
                }
            }

            
            attemptsLeft --;

            //checks the two condictions to end the game, no more tries or you have guess all 4 correctly
            if (black == 4) {
                loop = false;
                System.out.print("WINNER WINNER CHICKEN DINER");
            }
            if (attemptsLeft == 0) {
                loop = false;
                System.out.print("Round lost.");
            }

        } while (loop == true);

        scanner.close();
    }
}

