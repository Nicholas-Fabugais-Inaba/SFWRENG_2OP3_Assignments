/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
    Write a Java program, use 'subroutine', 'if', 'else if' and 'else' to solve a quadratic equation in the following form:

    a*x^2 + b*x + c = 0

 * INPUT: user input real valued coefficients: a, b, c.
 * These inputs should be fed as parameters into a subroutine that you write.
 *
 * OUTPUT: Output the solutions (i.e., roots) to the quadratic function defined by the coefficients a, b and c.
 * If there is no real roots, output: "The equation has no real roots."
 * The above outputs should be produced as a String variable returned by your subroutine.
 *
 * Note: all values must be displayed using two significant digits after decimal point.

*
* Example:
For a=1, b=5 and c=2, the roots are -0.44 and -4.56
 */

import java.util.Scanner;

public class Q1_SolveQuadraticEquation {

    public static String[] solver(int a,int b,int c, double discriminant) {

        String roots[] = new String[2];
        roots[0] = String.format("%.2f",(-b+Math.sqrt(discriminant))/(2*a));
        roots[1] = String.format("%.2f",(-b-Math.sqrt(discriminant))/(2*a));
        return roots;

    }

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter in a real valued coefficient a: ");
        int a = input.nextInt();
        System.out.println("Enter in a real valued coefficient b: ");
        int b = input.nextInt();
        System.out.println("Enter in a real valued coefficient c: ");
        int c = input.nextInt();

        double discriminant = Math.pow(b,2) - 4*a*c;

        if (discriminant < 0) {
            System.out.println("The equation has no real roots.");
        } else if (discriminant==0) {
            String[] x = solver(a, b, c, discriminant);
            System.out.println("For a=" + a + ", b=" + b + " and c=" + c + ", the root is " + x[0]);
        } else {
            String[] x = solver(a, b, c, discriminant);
            System.out.println("For a="+a+", b="+b+" and c="+c+", the roots are "+x[0]+" and "+x[1]);
        }


    }
}
