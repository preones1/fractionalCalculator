/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractionalcalculator;

import java.util.Scanner;

/**
 *
 * @author srodriguez
 */
public class FractionalCalculator {

    /**
     * @param args the command line arguments
     */
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String option = "";
        while (true) {
            System.out.println("Welcome to the fractional calculator");
            System.out.println("Please select an option");
            System.out.println(" [1] to sum fractions");
            System.out.println(" [2] to substract fractions");
            System.out.println(" [x] Exit");
            System.out.print("Option: ");
            option = reader.nextLine();
            if (option.equals("x")) {
                break;
            } else if (option.endsWith("1")) {
                System.out.println("");
                insertValues(option);
            } else if (option.endsWith("2")) {
                System.out.println("");
                insertValues(option);
            } else if (!option.equals("x") && !option.endsWith("1") && !option.endsWith("2")) {
                System.out.println("\n\tInvalid option, please try again\n");
            }
        }
    }

    public static void insertValues(String option) {
        String fraction1 = "";
        String fraction2 = "";
        //Fraction # 1
        while (true) {
            System.out.print("Input first fraction, the format must be A/B: ");
            fraction1 = reader.nextLine();
            // If there are blank spaces then remove them
            if (fraction1.contains(" ")) {
                fraction1 = removeSpaces(fraction1);
            }
            if (checkFraction(fraction1)) {
                break;
            }
        }
        while (true) {
            System.out.print("Input second fraction, the format must be A/B: ");
            fraction2 = reader.nextLine();
            // If there are blank spaces then remove them
            if (fraction2.contains(" ")) {
                fraction2 = removeSpaces(fraction2);
            }
            if (checkFraction(fraction2)) {
                break;
            }
        }
        if (option.equals("1")) {
            Addition add = new Addition(fraction1, fraction2);
            add.sum();
        } else if (option.equals("2")) {
            Subtraction add = new Subtraction(fraction1, fraction2);
            add.sub();
        }
    }

    public static boolean checkFraction(String fraction) {
        int enume, denom;
        String den = "";
        if (!fraction.isEmpty() && fraction.contains("/")) {
            String[] den1 = fraction.split("/");
            try {
                den = den1[1];
            } catch (ArrayIndexOutOfBoundsException c) {
                System.out.println("\n\tDenominator cannot be empty\n");
                return false;
            }
            try {
                enume = Integer.parseInt(den1[0]);
                denom = Integer.parseInt(den1[1]);
            } catch (NumberFormatException c) {
                System.out.println("\n\tA fraction consist of numbers and no letters or special characters\n");
                return false;
            }
        }
        if (fraction.isEmpty()) {
            System.out.println("\n\tFraction cannot be empty\n");
            return false;
        }
        if (!fraction.contains("/")) {
            System.out.println("\n\tIncorrect format, format must be A/B\n");
            return false;
        }
        if (!fraction.isEmpty() && fraction.contains("/") && den.equals("0")) {
            System.out.println("\n\tDenominator cannot be zero\n");
            return false;
        }
        return true;
    }

    public static String removeSpaces(String data) {
        String result = "";
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) != ' ') {
                result += data.charAt(i);
            }
        }
        return result;
    }
}
