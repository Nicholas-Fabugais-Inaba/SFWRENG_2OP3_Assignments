/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
 *
 * Write a subroutine, user input an 1D array of integers and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * INPUT: user input array and target
 * OUTPUT: the indices of the two numbers such that they add up to target.
 *
 * The array and target are parameters to the subroutine.
 * User can get hint to input array and target number, respectively.
 *
 * Keep the input format in the example and make your code user-friendly.
 *
 * Example:
 * INPUT: [2,7,11,15], 9
 * OUTPUT: [0,1]
 *
 */

import java.util.Scanner;

public class Q1_TwoSum {
    public static int[] i_twosum (int[] iarray, int itarget) {

        int counter = 0;
        while (true) {

            for (int i = 0; i < iarray.length; i++) {
                if (iarray[counter] == iarray[i]) {
                    continue;
                } else if ((iarray[counter]+iarray[i]) == itarget) {
                    int[] result = {counter,i};
                    return result;
                }
            }
            counter++;
            if (counter == iarray.length) {
                System.out.println("No two indices add up to target");
                System.exit(0);
            }

        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter in a 1D array of integers and an integer target (ie. '[2,7,11,15], 9'): ");
        String user_input = input.next();
        int target = input.nextInt();
        user_input = user_input.replace("[","");
        user_input = user_input.replace("]","");
        String[] user_input_array = user_input.split(",");
        int[] iarray = new int[user_input_array.length];
        for (int i = 0; i < iarray.length; i++) {
            iarray[i] = Integer.parseInt(user_input_array[i]);
        }
        System.out.println("["+i_twosum(iarray, target)[0]+","+i_twosum(iarray, target)[1]+"]");


    }

}
