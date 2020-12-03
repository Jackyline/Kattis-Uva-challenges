package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> maxGenerations = new ArrayList<Integer>();
        maxGenerations.add(3);       //1960
        maxGenerations.add(5);       //1970
        maxGenerations.add(8);       //1980
        maxGenerations.add(12);      //1990
        maxGenerations.add(20);      //2000
        maxGenerations.add(34);      //2010
        maxGenerations.add(57);      //2020
        maxGenerations.add(98);      //2030
        maxGenerations.add(170);     //2040
        maxGenerations.add(300);     //2050
        maxGenerations.add(536);     //2060
        maxGenerations.add(966);     //2070
        maxGenerations.add(1754);    //2080
        maxGenerations.add(3210);    //2090
        maxGenerations.add(5910);    //2100
        maxGenerations.add(10944);   //2110
        maxGenerations.add(20366);   //2120
        maxGenerations.add(38064);   //2130
        maxGenerations.add(71421);   //2140
        maxGenerations.add(134480);  //2150
        maxGenerations.add(254016);  //2160

        new Main().solveProblem(maxGenerations);
    }

    public void solveProblem(List<Integer> maxGenerations) {
        final Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt()) != 0) {
            int decade = (int) Math.floor((n - 1960)/10);
            System.out.println(maxGenerations.get(decade));
        }
        scanner.close();
    }

}