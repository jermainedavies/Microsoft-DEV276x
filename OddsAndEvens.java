import java.util.*;

public class OddsAndEvens {

    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static String userName;
    public static String userChoice;
    public static String cpuChoice;
    public static int userFingerNum;
    public static int cpuFingerNum = rand.nextInt(6);
    public static String gameResult;

    public static void greeting () {
        System.out.println("let's play Odds and evens.");
        System.out.println("What's your name");
        userName = scan.nextLine();
        System.out.println("Hi, " + userName + "! Would you like to be Odds or Evens?");
        System.out.println("O for odds; E for evens");
        userChoice = scan.next();

        if (userChoice.equals("o")) {
            userChoice = "Odds";
            cpuChoice = "Evens";
            System.out.println("You have chosen " + userChoice);
            System.out.println("CPU will be " + cpuChoice);

        }
        else if (userChoice.equals("e")) {
            userChoice = "Evens";
            cpuChoice = "Odds";
            System.out.println("You have chosen " + userChoice);
            System.out.println("CPU will be " + cpuChoice);

        }
        else {
            System.out.println("Please pick enter a valid value");
        }
        System.out.println("-----------------------------------------------------------------");

    }

    public static void playGame () {
        System.out.println("How many fingers would you like to play?");
        userFingerNum = scan.nextInt(6);
        System.out.println("You played " + userFingerNum + " fingers");
        System.out.println("CPU played " + cpuFingerNum + " fingers");
        int total = userFingerNum + cpuFingerNum;
        System.out.println("The total was: " + total);
        if (total % 2 == 0) {
            gameResult = "Evens";
            System.out.println("The result was: Even");
        } else if (total % 2 != 0) {
            gameResult = "Odds";
            System.out.println("The result was: Odd");
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public static void findWinner () {
        if (gameResult.equals(userChoice)){
            System.out.println(userName + " wins!");
        }

        else {
            System.out.println("CPU wins!");
            System.out.println("Better luck next time!");
        }

    }

    public static void main(String[] args){
        greeting();
        playGame();
        findWinner();
    }
}

