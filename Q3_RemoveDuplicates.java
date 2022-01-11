/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
 *
 * Write a Java program, user input a 1-dimension array of integers, firstly
 * sorting it in non-increasing order, and then remove the duplicates in the
 * array (if exists).
 *
 * INPUT: user input a 1-dimension array.
 * OUTPUT: sorted array in non-increasing order, and without any repeating element.
 *
 * Note: You must write sort algorithm by yourself, you are not supposed to
 * use Arrays.sort() to output the result directly.
 *
 * Hint: you can use bubble sorting algorithm or other sorting algorithms.
 *
 * Keep the input format in the example and make your code user-friendly.
 *
 * Example 1:
 * INPUT: [0, 1, 1, 0, 1, 2, 2, 3, 3, 4]
 * OUTPUT: [4, 3, 2, 1, 0]
 *
 * Example 2:
 * INPUT: [7, 0, 4, 2, 9]
 * OUTPUT: [9, 7, 4, 2, 0]
 *
 */

import java.util.Scanner;

public class Q3_RemoveDuplicates {
    public static int reorder (int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int num;
                if (arr[i] < arr[j]) {
                    num = arr[i];
                    arr[i] = arr[j];
                    arr[j] = num;
                }
            }
        }

        int[] arr_copy = new int[arr.length];
        int length = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i+1]) {
                arr_copy[length++] = arr[i];
            }
        }
        arr_copy[length++] = arr[arr.length-1];
        for (int i = 0; i < length; i++) {
            arr[i] = arr_copy[i];
        }

        return length;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter in a 1D array of integers (ie. '[1, 2, 3, 4]'): ");
        String user_input = input.nextLine();
        user_input = user_input.replace("[","");
        user_input = user_input.replace("]","");
        user_input = user_input.replace(" ","");
        String[] user_input_array = user_input.split(",");
        int[] iarray = new int[user_input_array.length];
        for (int i = 0; i < iarray.length; i++) {
            iarray[i] = Integer.parseInt(user_input_array[i]);
        }
        int larr = reorder(iarray);
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < larr; i++) {
            if (i == larr-1) {
                System.out.println(iarray[i]+"]");
            } else {
                System.out.print(iarray[i]+", ");
            }
        }
    }
}
