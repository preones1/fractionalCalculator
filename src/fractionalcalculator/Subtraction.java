/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractionalcalculator;

/**
 *
 * @author srodriguez
 */
public class Subtraction {

    private String fract1;
    private String fract2;

    public Subtraction(String fract1, String fract2) {
        this.fract1 = fract1;
        this.fract2 = fract2;
    }

    public void sub() {
        String[] fractOne = this.fract1.split("/");
        String[] fractTwo = this.fract2.split("/");
        int num1 = Integer.parseInt(fractOne[0]);
        int den1 = Integer.parseInt(fractOne[1]);
        int num2 = Integer.parseInt(fractTwo[0]);
        int den2 = Integer.parseInt(fractTwo[1]);
        int numerator = (num1 * den2) - (num2 * den1);
        int denominator = (den1 * den2);
        if (numerator % 3 == 0 && denominator % 3 == 0) {
            oddResult(numerator, denominator);
        } else if (numerator % 2 == 0 && denominator % 2 == 0) {
            evenResult(numerator, denominator);
        } else {
            System.out.println("\n\tResult of " + this.fract1 + " - " + this.fract2 + " : " + numerator + "/" + denominator);
            System.out.println("");
        }
    }

    public void oddResult(int num, int den) {
        while (num % 3 == 0 && den % 3 == 0) {
            num = num / 3;
            den = den / 3;
        }
        System.out.println("\n\tResult of " + this.fract1 + " - " + this.fract2 + " : " + num + "/" + den);
        System.out.println("");
    }

    public void evenResult(int num, int den) {
        while (num % 2 == 0 && den % 2 == 0) {
            num = num / 2;
            den = den / 2;
        }
        System.out.println("\n\tResult of " + this.fract1 + " - " + this.fract2 + " : " + num + "/" + den);
        System.out.println("");
    }

}
