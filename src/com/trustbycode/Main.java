package com.trustbycode;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numbersOfPayments = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between ($1K - $1M)");
        }
        while (true) {
            System.out.println("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <=30) {
                monthlyInterest = annualInterestRate / PERCENTAGE / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");

        }

        while (true) {
            System.out.println("Period (Years): ");
            byte period = scanner.nextByte();
            if (period >= 1 && period <= 30) {
                numbersOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments)) /(Math.pow(1 + monthlyInterest, numbersOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" +mortgageFormatted);
    }
}
