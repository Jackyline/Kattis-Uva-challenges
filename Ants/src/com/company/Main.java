package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().solveCases();
    }

    public void solveCases() {
        final Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i = 0; i < cases; ++i) {
            solveCase(scanner);
        }
        scanner.close();;
    }

    public void solveCase(Scanner scanner) {
        int pole = scanner.nextInt();
        int ants_nr = scanner.nextInt();
        int min = 0;
        int max = 0;
        int[] ants = new int[ants_nr];

        //Collect ants
        for(int ant = 0; ant < ants_nr; ++ant) {
            ants[ant] = scanner.nextInt();
        }

        //Solve min and max
        for(int i = 0; i < ants_nr; ++i) {
            int distEdge = pole - ants[i];
            min = Math.max(Math.min(distEdge, ants[i]), min);
            max = Math.max(Math.max(distEdge, ants[i]), max);
        }
        System.out.println(min + " " + max);
    }
}
