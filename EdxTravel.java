import java.util.Scanner;

public class EdxTravel {
    private static double destinationBudget;
    private static double dailyBudget;
    private static double areaInMiles;
    private static String nameInput;

    static void roundDestinationBudget() {
        destinationBudget *= 100;
        destinationBudget = (int) destinationBudget;
        destinationBudget = (float) destinationBudget;
        destinationBudget /= 100;
    }


    static void roundDailyBudget() {
        dailyBudget *= 100;
        dailyBudget = (int) dailyBudget;
        dailyBudget = (float) dailyBudget;
        dailyBudget /= 100;
    }
    static void roundMiles() {
        areaInMiles *= 100;
        areaInMiles = (int) areaInMiles;
        areaInMiles = (float) areaInMiles;
        areaInMiles /= 100;
    }

    static void greeting() {
        Scanner inputVar = new Scanner(System.in);
        System.out.println("Welcome to my travel app. What is your name?");
        nameInput = inputVar.nextLine();

        /*scanner is currently only holding one word at a time but some names are more than one word*/

        System.out.println("Hello, " + nameInput + "!");
        System.out.println("Where will you be travelling to?");
        String countryInput = inputVar.nextLine();
        System.out.println(countryInput + " is lovely at this time of year. Great choice!" );

    }

    static void durationAndBudget() {
        Scanner inputVar = new Scanner(System.in);
        System.out.println("How many days will you be away for?");
        int durationInput = inputVar.nextInt();
        System.out.println("what is your budget for the entire trip in USD?");
        double budgetInput = inputVar.nextDouble();
        System.out.println("What is the currency symbol for your destination?");
        String currencyInput = inputVar.next();
        System.out.println("Thanks for that.");
        System.out.println("What is the exchange rate for your destination's currency?");
        double exchangeRateInput = inputVar.nextDouble();
        System.out.println("Thanks.");
        int holidayInHours = durationInput * 24;
        int holidayInMins = durationInput * 1440;
        int holidayInSecs = durationInput * 86400;
        System.out.println("Your holiday will last for:");
        System.out.println(durationInput + " days, or");
        System.out.println(holidayInHours + " hours, or");
        System.out.println(holidayInMins + " minutes, or");
        System.out.println(holidayInSecs + " seconds");
        System.out.println("Your total holiday budget is " + budgetInput + " USD");
        dailyBudget = budgetInput / durationInput;
        roundDailyBudget();
        double targetCurrency = budgetInput * exchangeRateInput;
        destinationBudget = (budgetInput * exchangeRateInput) / durationInput;
        roundDestinationBudget();
        System.out.println("You can spend " + dailyBudget + " USD" + " a day.");
        System.out.println("Your total budget in " + currencyInput + " is " + targetCurrency);
        System.out.println("In " + currencyInput + ", that is " + destinationBudget + " " + currencyInput + " a day");
    }

    static void timeDifference(){
        Scanner inputVar = new Scanner(System.in);
        System.out.println("Enter your current time (24 hour format)");
        double currentTime = inputVar.nextDouble();
        System.out.println("Is there a time difference between your current location and your travel destination? (yes/no)");
        String timeDifferenceInput = inputVar.next();


        if (timeDifferenceInput.equals("yes")) {
            System.out.println("What is the time difference in hours? e.g. -1, 1, 2 etc");
            Integer timeDifference = inputVar.nextInt();
            System.out.println(timeDifference);
            if ((timeDifference >= -26) && (timeDifference <= 26)) {
                double newTime = currentTime + timeDifference;
                if (newTime >= 24) {
                    newTime %= 12;
                }
                if (newTime <= 12) {
                    System.out.println("The time in your destination is " + newTime + ":00" + "AM");
                }
                if (newTime > 12) {
                    System.out.println("The time in your destination is " + newTime + ":00" + "PM");

                }
            }

            else {
                System.out.println("Sorry, your answer was out of range.");
            }
        }
        else {
            System.out.println("How lucky!");
        }
    }

    static void calculateArea(){
        Scanner inputVar = new Scanner(System.in);
        System.out.println("What is the size of your destination in kilometres\u00B2?");
        double areaInput = inputVar.nextDouble();
        areaInMiles = areaInput * 0.621371;
        roundMiles();
        System.out.println("in miles that is " + areaInMiles);

    }



    public static void main(String[] args){
        greeting();
        durationAndBudget();
        timeDifference();
        calculateArea();
        System.out.println("Thanks for using my app, " + nameInput + "!"+  " I hope to see you here again soon!");

    }
}
