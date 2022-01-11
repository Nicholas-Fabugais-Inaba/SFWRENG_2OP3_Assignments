/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (30 marks)

Many companies use telephone numbers like 555-GET-Food so the number is easier for their customers to remember.
On a standard telephone, the alphabetic letters are mapped to numbers in the following fashion:

A, B, and C = 2
D, E, and F = 3
G, H, and I = 4
J, K, and L = 5
M, N, and O = 6
P, Q, R, and S = 7
T, U, and V = 8
W, X, y, and Z = 9
Write an application that asks the user to enter a 10-character telephone number in the format XXX-XXX-XXXX.
The application should display the telephone number with any alphabetic characters that appeared in the original
translated to their numeric equivalent.

Example: if the user enters 555GETFOOD the application should display 555-438-3663.
*

 */

import java.util.Scanner;

public class Q3_AlphabeticPhoneNumber
{
    private static Scanner input;

    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        System.out.println("Enter The Phone Number (With Letters): ");
        String initial_phone_number = input.nextLine();

        initial_phone_number = initial_phone_number.toUpperCase();
        long phone_number_final = full_number(initial_phone_number);

        System.out.printf("%nOutput phone number for '%s' is '%s'",
                initial_phone_number, phone_number_final);
    }

    public static long full_number(String initial_phone_number)
    {
        // Use long instead of int for 'number' if the string will be longer than max int value
        // 2147483647, which is '10 digits'
        long number = 0; // 'number' is the digital phone number to compute from the initial alphabetic phone number.



        String phone_number = initial_phone_number.replace("-","");
        StringBuilder phone_number_builder = new StringBuilder();

        for (int i = 0; i < phone_number.length(); i++) {

            char digit = phone_number.charAt(i);
            if (Character.isDigit(digit)) {
                phone_number_builder.append(digit);
            } else if (Character.isLetter(digit)) {
                switch (digit) {
                    case 'A':
                    case 'B':
                    case 'C':
                        digit = 2;
                        break;
                    case 'D':
                    case 'E':
                    case 'F':
                        digit = 3;
                        break;
                    case 'G':
                    case 'H':
                    case 'I':
                        digit = 4;
                        break;
                    case 'J':
                    case 'K':
                    case 'L':
                        digit = 5;
                        break;
                    case 'M':
                    case 'N':
                    case 'O':
                        digit = 6;
                        break;
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                        digit = 7;
                        break;
                    case 'T':
                    case 'U':
                    case 'V':
                        digit = 8;
                        break;
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                        digit = 9;
                        break;
                }
                phone_number_builder.append((int)digit);
            }
        }

        number = Long.parseLong(phone_number_builder.toString());



        // Return actual number only at the end of the function
        return number;

    }// End of full_number function
}
