/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
 *
 * Define a class "People", there are three parameters: "String name", "int age" and
 * "String gender", you can define them with keywords "public" and "private", so that
 * users can access "name" anywhere in class, but will have a compile-time error message
 * if they want to access "gender" and "age".
 *
 * Write a method getName() in class People, and call it in "main" to print member1 and
 * member2' names.
 *
 * Input: None
 * Output: all members' names.
 *
 */

public class Q3_People {

    //you can modify class People to finish the question
    static class People{

        public String name;
        private int age;
        private String gender;

        People(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        // define two members with following information
        // name:"Jack", age:19, gender:"Male";
        // name:"Rose", age:18, gender:"Female"

        People member1 = new People("Jack", 19, "Male");
        People member2 = new People("Rose", 18, "Male");
        System.out.println(member1.getName());
        System.out.println(member2.getName());

    }

}
