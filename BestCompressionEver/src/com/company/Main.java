package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solveCases();
    }

    public void solveCases() throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = scanner.readLine()) != null) {

        if(line.isEmpty()) {
            break;
        }

        String[] parts = line.split(" ");
        Long files = Long.parseUnsignedLong(parts[0]);
        int bytes = Integer.parseInt(parts[1]);
        if ((long) Math.pow(2.0,bytes + 1) > files) {
            System.out.println("yes");
            }
        else if((long) Math.pow(2.0,bytes + 1) <= files) {
            System.out.println("no");
            }
        }
        scanner.close();
    }
}
