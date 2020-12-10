package com.company;

import java.util.Scanner;

import static java.lang.Math.abs;


public class Main {

    public static void main(String[] args) {
        new Main().solveCases();
    }
    public void solveCases() {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        for(int i = 1; i <= testcases; ++i) {
            boolean valid = true;
            int current = 0;
            int columns = scanner.nextInt() - 1;
            int champ = abs(scanner.nextInt() - scanner.nextInt());
            for(int j = 1; j <= columns; j++) {
                int y1 = scanner.nextInt();
                int y2 = scanner.nextInt();
                current = abs(y1-y2);
                if (champ != current) {
                    valid = false;
                }
            }
            if (valid) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
            if (i != testcases) {
                System.out.println();
            }
        }
    }
}
