package com.company;

public class Menu {
    private static String printUnderLine(){
        return "---------------------------------------------------------";
    }

    public static void printMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append(printUnderLine()).append("\n");
        sb.append("Menu for supercalculator!\n");
        sb.append(printUnderLine()).append("\n");
        sb.append("1. tan(x)\n");
        sb.append("2. sin(x)\n");
        sb.append("3. ab^x\n");
        sb.append("4. x^y\n");
        sb.append("5. Quit\n");
        sb.append(printUnderLine());
        System.out.println(sb.toString());
    }

    public static void promptMenuInput(){
        System.out.println("Please select an option from 1 to 5: ");
    }

    public static void promptTangentInput(){
        System.out.println(printUnderLine());
        System.out.println("You've chosen to calculate for tan(x).");
        System.out.println("Enter an angle in degrees(needs to be integer) or press Z to return to main menu: ");
    }

    public static void promptSineInput(){
        System.out.println(printUnderLine());
        System.out.println("You've chosen to calculate for sin(x).");
        System.out.println("Enter an angle in degrees(needs to be integer) or press Z to return to main menu:");
    }

    public static void promptABXInput(){
        System.out.println(printUnderLine());
        System.out.println("You've chosen to calculate for ab^x.");
        System.out.println("Please enter a value for a, b and x in order and each value in a new line. Or press Z " +
                "to return to main menu: ");
    }

    public static void promptXYInput(){
        System.out.println(printUnderLine());
        System.out.println("You've chosen to calculate for x^y.");
        System.out.println("Please enter a value for x and y in order and each value in a new line. Or press Z to " +
                "return to main menu: ");
    }

    public static void printEnd(){
        System.out.println(printUnderLine());
        System.out.println("Thank you! See you again!");
        System.out.println(printUnderLine());
    }
}
