/* Assignment 3 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
    Write a Java program that accepts an integer (n, 0 <= n <= 9) and computes the value of n+nn+nnn.

 * INPUT: a user input integer n
 * OUTPUT: the value of n+nn+nnn.

* Hint: For n=2, the output is 2+22+222=246
 */

import java.util.Scanner;

public class Q3_PlayWithInteger {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter in an integer between 0 and 9: ");
            int n = input.nextInt();
            if (n < 0 || n > 9) {
                System.out.println("Invalid input");
            } else {
                System.out.println("For n = " + n + ", the output is " + n + " + "
                        + n + n + " + " + n + n + n + " = " + (n + n*11 + n*111));
                break;
            }
        }

    }
}
