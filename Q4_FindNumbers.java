/* Assignment 3 (100 marks in total; 5% of the final score of this course)
 *
 * Question 4 (20 marks)
    Write a Java program to print integer numbers between 1 to a user input integer n, which are divisible by 3, 5 and by both.

 * INPUT: a user input integer n
 * OUTPUT: all the integer numbers between 1 and n that are either divisible by 3 or by 5 or by both.

* Hint: For n=16, the output should be as follows.
    Divided by 3 -> 3, 6, 9, 12, 15.
    Divided by 5 -> 5, 10, 15.
    Divided by 3 and 5 -> 15.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q4_FindNumbers {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter in an integer: ");
        int n = input.nextInt();
        int divby3[] = new int[(n/3)];
        int divby5[] = new int[(n/5)];
        int divby3and5[] = new int[(n/15)];

        int div = 1;
        for (int i = 0; i < (n/3); i++) {
            divby3[i] = div*3;
            div++;
        }
        div = 1;
        for (int i = 0; i < (n/5); i++) {
            divby5[i] = div*5;
            div++;
        }
        div = 1;
        for (int i = 0; i < (n/15); i++) {
            divby3and5[i] = div*15;
            div++;
        }

        System.out.println("Divided by 3 -> "
                + Arrays.toString(divby3).replace("[","").replace("]","."));
        System.out.println("Divided by 5 -> "
                + Arrays.toString(divby5).replace("[","").replace("]","."));
        System.out.println("Divided by 3 and 5 -> "
                + Arrays.toString(divby3and5).replace("[","").replace("]","."));

    }
}
