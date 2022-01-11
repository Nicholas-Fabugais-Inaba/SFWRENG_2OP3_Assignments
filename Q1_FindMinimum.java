/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
 *
 * Write a Java program, use 'subroutine' to finds the minimum value of
 * the first N elements of an array of type int.
 * Meanwhile, your code can throw an IllegalException (custom run-time
 * exception, which can be one provided by Java) if N is not in the range
 * of the length of input array.
 *
 * Input: user input array and number N.
 * Output: the minimum value of the first N elements of the array.
 *
 * Note: The array and N are parameters to the subroutine.
 * Users will input an array with no specific length.
 *
 */

import java.util.Scanner;

public class Q1_FindMinimum {

    public static int find_min (int[] num_array, int num) {

        int min_num = num_array[0];
        int counter = 0;

        try {

            for (int i = 1; i < num; i++) {
                if (min_num < num_array[i]) {
                    continue;
                } else if (num_array[i] < min_num) {
                    counter += i;
                    min_num = num_array[counter];
                    counter = 0;
                }
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(num+" is not in the range of the length of the input array");
            System.exit(0);
        }
        return min_num;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a number for the length of an array of type int: ");
        int num_array_length = input.nextInt();
        int num_array[] = new int[num_array_length];
        for (int i = 0; i < num_array_length; i++) {
            System.out.println("Enter in an integer: ");
            num_array [i] = input.nextInt();
        }
        System.out.println("Input a number N: ");
        int N = input.nextInt();
        System.out.println("The minimum value of the first "+N+" elements of the array is "+find_min(num_array, N));

    }
}


