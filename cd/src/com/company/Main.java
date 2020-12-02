package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().SolveCdCases();
    }
    public void SolveCdCases() {
        final Scanner scanner = new Scanner(System.in);
        int jackCol = scanner.nextInt();
        int jillCol = scanner.nextInt();
        Map<Integer, Integer> jackCds = new HashMap<Integer, Integer>();
        while(!(jackCol == 0 && jillCol == 0)) {
            int duplicates = 0;

            //Collect jacks cds
            for(int i = 0; i< jackCol; ++i) {
                jackCds.put(scanner.nextInt(), 1);
            }
            //Collect jills cds
            for(int j = 0; j< jillCol; ++j) {
                int cd = scanner.nextInt();
                //Collect duplicates
                if(jackCds.get(cd) != null){
                    duplicates ++;
                }
            }

            System.out.println(duplicates);
            //Next case
            jackCol = scanner.nextInt();
            jillCol = scanner.nextInt();
            jackCds.clear();
        }
    }
}