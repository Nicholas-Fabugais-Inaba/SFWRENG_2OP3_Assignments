/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 4 (20 marks)
 *
 * Write a java program to compute the transpose of a user input matrix,
 * whose elements are all integers.
 *
 * Converting rows of a matrix into columns and columns of a matrix into
 * row is called transpose of a matrix.
 *
 * INPUT: user input matrix (2D array).
 * OUTPUT: the transpose of input matrix.
 *
 * Note: considering how to take users' input, you can set some rules
 * (give users some hints) to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example:
 * INPUT: 4  6  8
 *        5  8  9
 *        2  1  8
 *
 * OUTPUT: 4  5  2
 *         6  8  1
 *         8  9  8
 *
 */

import java.util.Scanner;

public class Q4_TransposeMatrix {
    public static int[][] transpose (int[][] arr, int row, int col) {

        int[][] arr_copy = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                arr_copy[i][j] = arr[j][i];
            }
        }

        return arr_copy;
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
        int[][] tmat = transpose(arr, row, col);
        System.out.println();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(tmat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
