/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 5 (20 marks)
 *
 * Write a java program to convert Roman numbers to integer.
 * Roman numerals are represented by seven different symbols:
 * I, V, X, L, C, D and M
 *
 * Symbol   Value
 *   I        1
 *   V        5
 *   X        10
 *   L        50
 *   C        100
 *   D        500
 *   M        1000
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written
 * as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *  I can be placed before V (5) and X (10) to make 4 and 9.
 *  X can be placed before L (50) and C (100) to make 40 and 90.
 *  C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Input: Roman number (user input, string type)
 * Output: print out corresponding integer
 *
 * Example: if the user enters 'LVIII', the program should output 'LVIII -> 58'
 *
 */

import java.util.Scanner;
public class Q5_Roman2Integer {

    public static int R2IConverter(String rnum) {
        int[] sum = new int[rnum.length()];
        int intsum = 0;
        for (int i = 0; i < rnum.length(); i++) {
            if (rnum.contains("M")) {
                if (rnum.contains("CM")) {
                    sum[i] = 900;
                    rnum = rnum.replace("CM"," ");
                } else if (rnum.contains("D") && rnum.indexOf("M") > rnum.indexOf("D")
                        || rnum.contains("L") && rnum.indexOf("M") > rnum.indexOf("L")
                        || rnum.contains("X") && rnum.indexOf("M") > rnum.indexOf("X")
                        || rnum.contains("V") && rnum.indexOf("M") > rnum.indexOf("V")
                        || rnum.contains("I") && rnum.indexOf("M") > rnum.indexOf("I")) {
                    System.out.println("Invalid roman numeral inputted");
                    System.exit(0);
                } else {
                    sum[i] = 1000;
                    rnum = rnum.replaceFirst("M"," ");
                }
            } else if (rnum.contains("D")) {
                if (rnum.contains("CD")) {
                    sum[i] = 400;
                    rnum = rnum.replace("CD"," ");
                } else if (rnum.contains("L") && rnum.indexOf("D") > rnum.indexOf("L")
                        || rnum.contains("X") && rnum.indexOf("D") > rnum.indexOf("X")
                        || rnum.contains("V") && rnum.indexOf("D") > rnum.indexOf("V")
                        || rnum.contains("I") && rnum.indexOf("D") > rnum.indexOf("I")) {
                    System.out.println("Invalid roman numeral inputted");
                    System.exit(0);
                } else {
                    sum[i] = 500;
                    rnum = rnum.replaceFirst("D"," ");
                }
            } else if (rnum.contains("C")) {
                if (rnum.contains("XC")) {
                    sum[i] = 90;
                    rnum = rnum.replace("XC"," ");
                } else if (rnum.contains("L") && rnum.indexOf("C") > rnum.indexOf("L")
                        || rnum.contains("V") && rnum.indexOf("C") > rnum.indexOf("V")
                        || rnum.contains("I") && rnum.indexOf("C") > rnum.indexOf("I")) {
                    System.out.println("Invalid roman numeral inputted");
                    System.exit(0);
                } else {
                    sum[i] = 100;
                    rnum = rnum.replaceFirst("C"," ");
                }
            } else if (rnum.contains("L")) {
                if (rnum.contains("XL")) {
                    sum[i] = 40;
                    rnum = rnum.replace("XL"," ");
                } else if (rnum.contains("V") && rnum.indexOf("L") > rnum.indexOf("V")
                        || rnum.contains("I") && rnum.indexOf("L") > rnum.indexOf("I")) {
                    System.out.println("Invalid roman numeral inputted");
                    System.exit(0);
                } else {
                    sum[i] = 50;
                    rnum = rnum.replaceFirst("L"," ");
                }
            } else if (rnum.contains("X")) {
                if (rnum.contains("IX")) {
                    sum[i] = 9;
                    rnum = rnum.replace("IX"," ");
                } else if (rnum.contains("V") && rnum.indexOf("X") > rnum.indexOf("V")) {
                    System.out.println("Invalid roman numeral inputted");
                    System.exit(0);
                } else {
                    sum[i] = 10;
                    rnum = rnum.replaceFirst("X"," ");
                }
            } else if (rnum.contains("V")) {
                if (rnum.contains("IV")) {
                sum[i] = 4;
                rnum = rnum.replace("IV"," ");
                } else {
                    sum[i] = 5;
                    rnum = rnum.replaceFirst("V"," ");
                }
            } else if (rnum.contains("I")) {
                sum[i] = 1;
                rnum = rnum.replaceFirst("I"," ");
            } else {
                System.out.println("Invalid roman numeral inputted");
                System.exit(0);
            }
        }
        for (int i = 0; i < sum.length; i++) {
            intsum += sum[i];
        }
        return intsum;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter in a roman numeral: ");
        String roman_numeral = input.next();
        System.out.println(roman_numeral+" -> "+R2IConverter(roman_numeral));

    }
}
