/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 4 (30 marks)

Write a program that generates a random number y and asks the user to guess what the number is.
If the user's guess x is higher than y,the program should display "The number is lower than x." and asks the user to guess again.
If the user's guess x is lower than y, the program should display "The number is higher than x." and asks the user to guess again.
If the user exceed a certain times of trails (i.e., 10 times), then the program should display "You have exhausted your trials" and stop.
If the user successfully guess the number, then the program should display "You successfully guessed the number!".
 */

import java.util.Scanner;

public class Q4_GuessNumberGame {

    // Function that implements the number guessing game
    public static void guessingNumberGame(int number_to_guess, int number_of_trials) {

        Scanner input = new Scanner(System.in);
        int y = number_to_guess;
        System.out.println(y);
        for (int i = 0; i < number_of_trials; i++) {

            System.out.println("Enter in a guess for the number: ");
            int x = input.nextInt();

            if (x > y) {
                System.out.println("The number is lower than x.");
            } else if (x < y) {
                System.out.println("The number is higher than x.");
            } else {
                System.out.println("You successfully guessed the number!");
                System.exit(0);
            }
        }
        System.out.println("You have exhausted your trials");

    }

    public static void main(String arg[]) {
        // Generate the numbers
        int number_to_guess = 1 + (int)(50 * Math.random()); // the random number y to guess
        int number_of_trials = 10; // the total times of trials

        // start guessing
        guessingNumberGame(number_to_guess, number_of_trials);
    }
}