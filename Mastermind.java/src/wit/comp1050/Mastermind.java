package wit.comp1050;
import java.util.Random;
import java.util.*;


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
    
    public static int tallyGuesses(int[] arr, int guess1, int guess2, int guess3, int guess4) {
        int count = 0;
        if (arr[0] == guess1) {
            count++;
        }
        if (arr[1] == guess2) {
            count++;
        }
        if (arr[2] == guess3) {
            count++;
        }
        if (arr[3] == guess4) {
            count++;
        }
        return count;
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

        short difficulty = 0;
        System.out.println("Choose your difficulty: (1)>Beginner | (2)>Intermediate | (3)>Advanced");
        System.out.print(">>>");
        difficulty = (short) scanner.nextInt();
        System.out.print("\n");

        int[] colors = new int[4];   
        switch(difficulty) {
            case 1:  

            colors[0] = random.nextInt(3);
            colors[1] = random.nextInt(3);
            colors[2] = random.nextInt(3);
            colors[3] = random.nextInt(3);
            break;

            case 2:  
            colors[0] = random.nextInt(4);
            colors[1] = random.nextInt(4);
            colors[2] = random.nextInt(4);
            colors[3] = random.nextInt(4);
            break; 


            case 3:  
            colors[0] = random.nextInt(5);
            colors[1] = random.nextInt(5);
            colors[2] = random.nextInt(5);
            colors[3] = random.nextInt(5);
            break;

        }


        boolean loop = true;

        int black = 0;
        int white = 0;
        int attemptsLeft = 6;
        int[] correctGuesses = new int[4];
        //game loop
        do {


            //user display, each color has a number B represents how many black pegs you have and white the same. 
            switch(difficulty) {
                case 1:
                    System.out.printf("colors: red(0) | blue(1) | yellow(2) | green(3)>> B:%s%s%s%s | Attempts Left:%s %n", correctGuesses[0], correctGuesses[1], correctGuesses[2], correctGuesses[3], attemptsLeft);
                    System.out.print("choose 4 colors seperated by space: ");
                    black = 0;

                    break;

                case 2:

                    System.out.printf("colors: red(0) | blue(1) | yellow(2) | green(3) | brown(4)>> B:%s W:%s | Attempts Left:%s %n", black, white, attemptsLeft);
                    System.out.print("choose 4 colors seperated by space: ");
                    black = 0;

                break;

                case 3:
                    System.out.printf("colors: red(0) | blue(1) | yellow(2) | green(3) | brown(4) | black(5)>> B:%s W:%s | Attempts Left:%s %n", black, white, attemptsLeft);
                    System.out.print("choose 4 colors seperated by space: ");
                    black = 0;

                break;
            }




            int guess0 = scanner.nextInt();
            int guess1 = scanner.nextInt();
            int guess2 = scanner.nextInt();
            int guess3 = scanner.nextInt();

            switch(difficulty){
                case 1:

                if (guess0 == colors[0]) {
                    correctGuesses[0] = 1;
                    black ++;
                } else{
                    correctGuesses[0] = 0;
                }

                if (guess1 == colors[1]) {
                    correctGuesses[1] = 1;
                    black++;
                } else{
                    correctGuesses[1] = 0;
                }

                if (guess2 == colors[2]) {
                    correctGuesses[2] = 1;
                    black++;
                } else{
                    correctGuesses[2] = 0;
                }                
                
                if (guess3 == colors[3]) {
                    correctGuesses[3] = 1;
                    black++;
                } else{
                    correctGuesses[3] = 0;
                }

                if (black == 4){
                    System.out.print("Congrats you win.");
                    System.exit(0);
                }
                if (attemptsLeft == 0){
                    System.out.print("You lose");
                    System.exit(0);
                }
            
                attemptsLeft --;
                break;
            
                case 2:
                black = tallyGuesses(colors, guess0, guess1, guess2, guess3);
                if (black == 4){
                System.out.print("Congrats you win.");
                System.exit(0);
                }
                if (attemptsLeft == 0){
                System.out.print("You lose");
                System.exit(0);
                }

                attemptsLeft --;
                break;

                case 3:
                black = tallyGuesses(colors, guess0, guess1, guess2, guess3);
                if (black == 4){
                System.out.print("Congrats you win.");
                System.exit(0);
                }
                if (attemptsLeft == 0){
                System.out.print("You lose");
                System.exit(0);
                }

                attemptsLeft --;
                break;
            }


        } while (loop == true);

        scanner.close();
    }
}

