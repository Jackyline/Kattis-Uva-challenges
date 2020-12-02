package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().collectData();
    }
    public void collectData() throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(scanner.readLine());
        //Remove line between nr of testcases and data
        String empty = scanner.readLine();
        for(int i = 1; i <= testcases; ++i) {
            Map<String, Double> species = new TreeMap<>();
            showPopulation(species, scanner, i, testcases);
        }
    }

    public void showPopulation(Map<String, Double> species, BufferedReader scanner, int case_nr, int test_cases) throws IOException {
        Double nr_trees = 0.0;
        String wood;
        while((wood = scanner.readLine()) != null){
            if(wood.isEmpty()) {
                break;
            }

            if(species.containsKey(wood)) {
                species.replace(wood, species.get(wood) + 1.0);
                nr_trees ++;
            }
            if(!species.containsKey(wood)) {
                species.put(wood, 1.0);
                nr_trees ++;
            }
        }
        if(nr_trees != 0) {
            for (String tree: species.keySet()) {
                System.out.format("%s %.4f\n", tree, species.get(tree) * 100 / nr_trees);
            }
            if(case_nr != test_cases){
                System.out.print("\n");
            }
        }

    }
}
