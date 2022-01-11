/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
 *
 * Write a java program, use "subroutine" to finish sorting a 2-dimension array.
 *
 * User input a 2-dimension array of double type, return it in non-decreasing
 * order according to values in the first raw, if there are two or more same
 * element in the first raw, keep the original sequence.
 *
 * INPUT: a user input 2-dimension array.
 * OUTPUT: sorted input array in non-decreasing order according to values in the first raw.
 *
 * Note: considering how to take users' input, you can set some rules (give users some hints)
 * to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example 1
 * INPUT: if user input array (Order 2*4) is
 *        1.45  0.25  8.95  0.99
 *        2.56  5.67  0.47  2.65
 *
 * OUTPUT: 0.25  0.99  1.45  8.95
 *         5.67  2.65  2.56  0.47
 *
 * Example 2
 * INPUT: if user input array (Order 5*5) is
 *        0.95  0.23  0.95  0.95  0.65
 *        2.56  5.67  0.47  2.65  0.47
 *        1.45  0.25  8.95  0.99  0.67
 *        5.67  2.65  0.25  8.95  0.99
 *        1.23  4.21  0.97  7.64  8.52
 *
 * OUTPUT: 0.23  0.65  0.95  0.95  0.95
 *         5.67  0.47  2.56  0.47  2.65
 *         0.25  0.67  1.45  8.95  0.99
 *         2.65  0.99  5.67  0.25  8.95
 *         4.21  8.52  1.23  0.97  7.64
 *
 */

import java.util.Scanner;

public class Q2_Sort2DArray {
    public static double[][] sort_arr(double[][] arr) {

        while (true) {
            int restart = 0;
            for (int i = 0; i < arr[0].length; i++) {
                for (int j = i+1; j < arr[0].length; j++) {
                    double num;
                    if (arr[0][i] > arr[0][j]) {
                        for (int k = 0; k < arr.length; k++) {
                            num = arr[k][i];
                            arr[k][i] = arr[k][j];
                            arr[k][j] = num;
                        }
                    } else if (arr[0][i] == arr[0][j]) {
                        break;
                    }
                }
            }
            for (int i = 0; i < arr[0].length; i++) {
                for (int j = i+1; j < arr[0].length; j++) {
                    if (arr[0][i] <= arr[0][j]) {
                        if (arr.length-2 == i && arr.length-1 == j) {
                            if (arr[0][arr.length-2] <= arr[0][arr.length-1]) {
                                return arr;
                            } else {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        restart = 1;
                        break;
                    }
                }
                if (restart == 1) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many rows of numbers are being inputted: ");
        int row = input.nextInt();
        System.out.println("How many columns of numbers are being inputted: ");
        int col = input.nextInt();
        double[][] arr = new double[row][col];
        for (int i = 0; i < row; i++) {
            System.out.println("Enter in a set of numbers for row "+(i+1)+" (ie. '1 2 3 4'): ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.nextDouble();
            }
        }
        arr = sort_arr(arr);
        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
