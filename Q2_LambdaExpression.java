/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
 *
 * Use a "subroutine" and a lambda expression to implement function
 * f(x,y) = sqrt(x*x-y*y), both x and y are real numbers.
 * Meanwhile, your code can throw an IllegalException (custom run-time exception,
 * which can be one provided by Java) if the value of (x*x-y*y) is negative.
 *
 * INPUT: the value of x and y (user input)
 * OUTPUT: the value of sqrt(x*x-y*y)
 *
 * Note: output must be displayed using four significant digits after decimal point.
 *
 */

import java.util.Scanner;

public class Q2_LambdaExpression {
    public interface lambda_func {

        double valueAt(double x, double y);

    }

    static lambda_func func = (x, y) -> {
        try {
            if ((x * x - y * y) < 0) {
                throw new ArithmeticException();
            } else {
                return Math.sqrt(x * x - y * y);
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot square root a negative number");
            System.exit(0);
        }
        return 0;
    };

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Input a value for x: ");
        double x = input.nextDouble();
        System.out.println("Input a value for y: ");
        double y = input.nextDouble();
        System.out.printf("The value of f(x,y) = "+"%.4f",func.valueAt(x,y));

    }
}
