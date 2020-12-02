package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        boolean scan = true;
        String day = "";
        while (scan) {
            List<String> days = new ArrayList<>();
            if (day.equals("")){
                day = scanner.nextLine();
            }
            while(!day.equals("-")) {
                if (!day.equals("-")) {
                    days.add(day);
                }
                day = scanner.nextLine();
            }
            day = scanner.nextLine();

            //Solve case
            SolveCase(days);

            if (day.equals("-")) {
                scan = false;
            }
        }
    }

    public void SolveCase(List<String> days) {
        double total_c_days = 0;
        double total_fat_days = 0;

        for (String day: days) {
            double fat = 0;
            double calories = 0;
            double prec_sum = 0;
            double fat_prec = 0;
            String[] food_items = day.split(" ");
            for(int i = 0; i<food_items.length; i++){
                if (food_items[i].charAt(food_items[i].length() - 1) == '%') {
                    prec_sum += Integer.parseInt(food_items[i].substring(0, food_items[i].length() - 1));
                }
                if ((!(food_items[i].charAt(food_items[i].length() - 1) == '%'))) {
                    calories += getSort(i, food_items[i]);
                }
                //Collect fat
                if (i == 0){
                    if (food_items[i].charAt(food_items[i].length() - 1) == '%') {
                        fat_prec += Integer.parseInt(food_items[i].substring(0, food_items[i].length() - 1));
                    }
                    if (food_items[i].charAt(food_items[i].length() - 1) == 'g' ||food_items[i].charAt(food_items[i].length() - 1) == 'C')
                    fat += getSort(i, food_items[i]);
                }
            }
            if (prec_sum > 0 ) {
                double prec_cal = calories / (100 - prec_sum);
                prec_cal = prec_cal * prec_sum;
                calories += prec_cal;
            }
            if(fat_prec > 0){
                double fat_C = calories*(fat_prec/100);
                fat += fat_C;
            }
            if (fat > 0) {
                total_fat_days += fat;
            }
            if (calories > 0) {
                total_c_days += calories;
            }
        }
        //This has to be done before the fat_prec because the recalc on calories.

        double fatPerc = (total_fat_days/total_c_days) * 100;
        System.out.println((int)Math.round(fatPerc) + "%");
    }

    public Double getSort(int index, String item) {
        double total = Integer.parseInt(item.substring(0, item.length() - 1));
        double calories = 0;
        switch(index) {
            case 0:
                 if(item.charAt(item.length() - 1) == 'g') {
                    calories = total * 9;
                    return calories;
                }
                return total;
            case 1:
            case 2:
            case 3:
                if(item.charAt(item.length() - 1) == 'g') {
                    calories = total * 4;
                    return calories;
                }
                return total;
            case 4:
                if(item.charAt(item.length() - 1) == 'g') {
                    calories = total * 7;
                    return calories;
                }
                return total;
        }
        return (double) 0;
    }
}
