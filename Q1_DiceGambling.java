/* Assignment 8 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (40 marks)
    Use java to implement a class Dice, a class Gambler and a method that continue gambling between two gamblers until one
    gambler cannot afford the stake.

 */

// the class of Dice to play
class Dice {
    private int num_faces;

    Dice(){
        num_faces=6; // standard dice with 6 faces by default.
    }

    // implement the roll dice method that roll the dice once and return the value of the roll.
    // (5 marks)
    public int rollDice() {
        int roll = (int) (Math.random()*num_faces)+1;
        return roll;
    }
}

// the class of gambler
class Gambler {
    public int money;
    public Dice die;

    Gambler(int initial_money) {
        money = initial_money;
        die = new Dice();
    }

    // use static method to implement the gambling activity.
    // In a gambling activity, two gamblers gamble on a stake.
    // Each gambler rolls a die, the gambler who roles a larger value wins the stake.
    // if it is a due, then roll again, until there is a winner.
    // Note: a gambler cannot start gamble if he does not have more money than the amount of stake.
    // Note: return false if at least one gambler cannot afford the stake. Otherwise, return true.
    // Note: print the result of rolled dice values, and the winner of the gambling.
    // (20 marks)
    static boolean gambling(Gambler gambler_1, Gambler gambler_2, int stake) {
        if (stake > gambler_1.money || stake > gambler_2.money) {
            return false;
        }
        int g1_roll = gambler_1.die.rollDice();
        int g2_roll = gambler_2.die.rollDice();
        while (true) {
            System.out.println("Gambler 1 rolls a "+g1_roll);
            System.out.println("Gambler 2 rolls a "+g2_roll);
            if (g1_roll > g2_roll) {
                System.out.println("Gambler 1 wins!");
                gambler_1.money += stake;
                gambler_2.money -= stake;
                return true;
            } else if (g2_roll > g1_roll) {
                System.out.println("Gambler 2 wins!");
                gambler_2.money += stake;
                gambler_1.money -= stake;
                return true;
            } else {
                System.out.println("Roll again");
            }
        }
    }
}

public class Q1_DiceGambling {

    // Continue Gambling until one gambler cannot afford the stake
    // Print the amount of money of each gambler after each round of gambling.
    // Print the value of rolled dice for each gambler in each round of gambling.
    // (15 marks)
    public static void keepGambling(Gambler gambler_1, Gambler gambler_2, int stake, int max_gambling_times) {
        for (int i = 0; i < max_gambling_times; i++) {
            if (stake > gambler_1.money || stake > gambler_2.money) {
                break;
            }
            Gambler.gambling(gambler_1,gambler_2,stake);
            System.out.println("Gambler 1's money: "+gambler_1.money);
            System.out.println("Gambler 2's money: "+gambler_2.money);
        }
    }

    public static void main(String[] args) {
        int initial_money = 10;
        int stake = 5;
        int max_gambling_times = 10;

        Gambler gambler1 = new Gambler(initial_money);
        Gambler gambler2 = new Gambler(initial_money);

        keepGambling(gambler1, gambler2, stake, max_gambling_times);

    }
}
