package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblems();
    }

    public void solveProblems() {
        final Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int i = 0; i < testCases; ++i) {
            int[] mapSize = new int[2];
            mapSize[0] = scanner.nextInt();
            mapSize[1] = scanner.nextInt();
            int[] startPos = new int[2];
            startPos[0] = scanner.nextInt();
            startPos[1] = scanner.nextInt();
            int nrBeepers = scanner.nextInt();
            List<List<Integer>> beepers = new ArrayList<>();
            for(int j = 0; j < nrBeepers; ++j) {
                List<Integer> beeper = new ArrayList<>();
                beeper.add(scanner.nextInt());
                beeper.add(scanner.nextInt());
                beepers.add(beeper);
            }
            List<List<Integer>> dist = new ArrayList<>();
        }
    }

    public List<List<Integer>> nearestNeighbours(List<List<Integer>> beepers, int[] startPos) {
        
    }
}
