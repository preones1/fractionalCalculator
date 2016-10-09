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
public class Addition {

    private String fract1;
    private String fract2;

    public Addition(String fract1, String fract2) {
        this.fract1 = fract1;
        this.fract2 = fract2;
    }

    public void sum() {
        String[] fractOne = this.fract1.split("/");
        String[] fractTwo = this.fract2.split("/");
        int num1 = Integer.parseInt(fractOne[0]);
        int den1 = Integer.parseInt(fractOne[1]);
        int num2 = Integer.parseInt(fractTwo[0]);
        int den2 = Integer.parseInt(fractTwo[1]);
        int numerator = (num1 * den2) + (num2 * den1);
        int denominator = (den1 * den2);
        if (numerator % 3 == 0 && denominator % 3 == 0) {
            oddResult(numerator, denominator);
        } else if (numerator % 2 == 0 && denominator % 2 == 0) {
            evenResult(numerator, denominator);
        } else {
            print(numerator, denominator);
        }
    }

    public void oddResult(int num, int den) {
        int nume = num, denome = den;
        while (nume != 0 && nume % 3 == 0 && denome % 3 == 0) {
            nume = nume / 3;
            denome = denome / 3;
        }
        print(nume, denome);
    }

    public void evenResult(int num, int den) {
        int nume = num, denome = den;
        while (nume != 0 && nume % 2 == 0 && denome % 2 == 0) {
            nume = nume / 2;
            denome = denome / 2;
        }
        print(nume, denome);
    }

    public void print(int num, int den) {
        if (num == 1 && den == 1) {
            System.out.println("\n\tResult of " + this.fract1 + " + " + this.fract2 + " : " + num + "/" + den + " = 1" + "\n");
        } else {
            System.out.println("\n\tResult of " + this.fract1 + " + " + this.fract2 + " : " + num + "/" + den + "\n");
        }
    }

}
