/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
    Write a java program to display the number rhombus structure.

 * INPUT: user input integer value: n
 * The input should be fed into a subroutine as parameter.
 *
 * OUTPUT: the rhombus structure corresponding to n. (see the following example)
 * Your subroutine should directly print the result and do not return anything.

*
* Example:
* For n=7, the rhombus structure is:
      1
     212
    32123
   4321234
  543212345
 65432123456
7654321234567
 65432123456
  543212345
   4321234
    32123
     212
      1

* For n=3, the rhombus structure is:
  1
 212
32123
 212
  1

 */

import java.util.Scanner;

public class Q2_ShowRhombus {

    public static void rhombus(int n) {

        int numSpaces = 1;
        int numCount = 1;
        int num = 0;

        for (int i=1; i<(n*2); i++) {

            for (int space=n-numSpaces; space>0; space--) { // space is the number of spaces before the number outputted
                System.out.print(" ");
            } if (i<n) {    // the number of spaces decrease
                num=i;
                numSpaces++;
            } else {    // the number of spaces increase
                num = n*2-i;
                numSpaces--;
            }
            for (int j = 0; j < numCount; j++) {
                System.out.print(num);
                if (j<numCount/2) {
                    num--;
                } else {
                    num++;
                }
            }
            if (i<n) {
                numCount+=2;
            } else {
                numCount-=2;
            }
            System.out.println();
        }


    }

    public static void main(String args[])
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter in an integer n: ");
        int n = input.nextInt();
        rhombus(n);

    }
}
