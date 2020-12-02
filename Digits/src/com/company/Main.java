package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().solveCases();
    }

    public void solveCases() {
        final Scanner scanner = new Scanner(System.in);
        String caseDigit = scanner.nextLine();
        while(!caseDigit.equals("END")) {

            if(caseDigit.equals("1")) {
                System.out.println(1);
            }

            if(caseDigit.equals("0") || caseDigit.equals("2") || caseDigit.equals("4")) {
                System.out.println(2);
            }
            if(!caseDigit.equals("0") && !caseDigit.equals("2") && !caseDigit.equals("4") && !caseDigit.equals("1")) {
                int loops = 2;
                int lengthOfDigits = caseDigit.length();
                for(int i = 2; lengthOfDigits > 1; ++i) {
                    caseDigit = Integer.toString(caseDigit.length());
                    lengthOfDigits = caseDigit.length();
                    loops = i + 1;
                }
                System.out.println(loops);
            }
            caseDigit = scanner.nextLine();
        }
        scanner.close();
    }
}
