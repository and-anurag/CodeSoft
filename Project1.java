import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("The game has four level hints\n" +
                "Hint 1: Too Low - means the guess no is much less than the generated no.(Difference more than 20)\n" +
                "Hint 2: Too High - means the guess no is much higher than the generated no.(Difference more than 20)\n" +
                "Hint 3: Low - means the guess no is less than the generated no.(Difference less than 20)\n" +
                "Hint 4: Low - means the guess no is higher than the generated no.(Difference less than 20)\n" );

        boolean playAgain = true;

        while (playAgain){

            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);

            while (true){

                try{

                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if((targetNumber-guess)>20){

                        System.out.println("Too low! Try again.\n");

                    }

                    else if((guess-targetNumber)>20){

                        System.out.println("Too high! Try again.\n");

                    }

                    else if(guess < targetNumber){

                        System.out.println("Low! Try again.\n");

                    }


                    else if(guess > targetNumber){

                        System.out.println("High! Try again.\n");

                    }


                    else{

                        System.out.println("\nCongratulations! You guessed the number in " + attempts + " attempts.");
                        int score = calculateScore(attempts);
                        System.out.println("Your score: " + score);
                        break;

                    }

                }

                catch (InputMismatchException e){

                    System.out.println("Please enter correct input.");
                    scanner.nextLine();

                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");

        }

        scanner.close();

        System.out.printf("\nThank You for playing the game.\n" + "Game Ended Successfully\n" + "Developed By: BlueBlood-exe\n\n");

    }


    public static int calculateScore(int attempts){

        return 1000 - (attempts-1) * 50;

    }
}
