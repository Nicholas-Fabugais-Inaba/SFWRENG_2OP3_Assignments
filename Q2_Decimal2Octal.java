/* Assignment 3 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
    Write a Java program to convert a decimal number (i.e., int value) to octal number.
    Please DO NOT use any Java provided subroutines or any third party subroutines to do the conversion.
    You should write your own code to convert a decimal number to octal number.

    Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.
    Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.


 * INPUT: a user input decimal number x
 * OUTPUT: an octal number y converted from x

* Hint: For a decimal number x=1256, the corresponding octal number is y=2350.
 */

import java.util.Scanner;

public class Q2_Decimal2Octal {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input a decimal number: ");
        int x = input.nextInt();
        int decimalNum = x;
        String y = "";
        int remainder;
        char octalnumsys[] = {'0', '1', '2', '3', '4', '5', '6', '7'};


        while (x > 0) {
            remainder = x % 8;
            y = octalnumsys[remainder] + y;
            x /= 8;
        }

        System.out.println("For a decimal number x = " + decimalNum + ", the corresponding octal number is y = " + y);

    }
}
