package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void processTangent(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            Menu.promptTangentInput();
            try {
                String input = scanner.nextLine().trim();
                if(input.length() == 1 && input.toLowerCase().equals("z")){
                    break;
                }
                System.out.println("The output for tan(" + input +
                        ") is " + Calculator.calculateTan(Integer.parseInt(input)));
                break;
            } catch (InputMismatchException e) {
                System.out.println("Your input needs to be an integer in the range -2147483648" +
                        " to 2147483647. Please try again.");
            } catch (ArithmeticException | NumberFormatException e) {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }

    public static void processABX(){
        Menu.promptABXInput();
        String a = Calculator.checkValid();
        String b = Calculator.checkValid();
        String c = Calculator.checkValid();

        Calculator.function5or6(a, b, c);
    }

    public static void processSine(){
        Menu.promptSineInput();
        Calculator.function3or4();
    }

    public static void processXY(){
        Menu.promptXYInput();
        ScientificCalculator.function7or8();
    }

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.printMenu();
            Menu.promptMenuInput();
            choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 5 || choice < 1) {
                    throw new InputMismatchException("Inappropriate input!");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Input error!");
            }

            switch (choice) {
                case 1:
                    processTangent();
                    break;
                case 2:
                    processSine();
                    break;
                case 3:
                    processABX();
                    break;
                case 4:
                    processXY();
                    break;
                case 5:
                    Menu.printEnd();
                    System.exit(0);
            }
        }

    }
}
