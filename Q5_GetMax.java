/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 5 (20 marks)
 *
 * Write a complete static method that finds the largest value in a 2-dimension array of ints.
 * The method should have one parameter, which is a 2d array of type int. The largest number
 * in the array should be returned as the value of the method.
 *
 * INPUT: user input a 2-dimension array of type int
 * OUTPUT: the largest number in input array
 *
 * Note: considering how to take users' input, you can set some rules (give users some hints)
 * to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example:
 * Input: 4  6  8
 *        5  8  9
 *        2  1  8
 * Output: 9
 *
 */

import java.util.Scanner;

public class Q5_GetMax {
    public static int max (int[][] arr) {

        int num = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (num == arr[i][j]) {
                    continue;
                } else if (arr[i][j] > num) {
                    num = arr[i][j];
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many rows of numbers are being inputted: ");
        int row = input.nextInt();
        System.out.println("How many columns of numbers are being inputted: ");
        int col = input.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.out.println("Enter in a set of numbers for row "+(i+1)+" (ie. '1 2 3 4'): ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        System.out.println();
        System.out.println(max(arr));
    }
}
