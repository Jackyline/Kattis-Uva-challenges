package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().CollectData();
    }

    public void CollectData() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int case_numbers = 0;
        int nr_candidates = 1001;
        while (nr_candidates != 0) {
            //The case number
            case_numbers++;
            if (scanner.hasNext()) {
                if (nr_candidates == 1001) {
                    nr_candidates = scanner.nextInt();
                }
            }
            int[] candidates = new int[nr_candidates];
            //get candidates
            for (int i = 0; i < nr_candidates; i++) {
                if (scanner.hasNext()) {
                    candidates[i] = scanner.nextInt();
                }
            }
            //all possible sums
            List<Integer> sums = collect_candidates(candidates);
            int nr_limits = 0;
            if (scanner.hasNext()) {
                nr_limits = scanner.nextInt();
            }
            if (scanner.hasNext()) {
                System.out.println("Case " + case_numbers + ":");
            }
            for (int j = 0; j < nr_limits; j++) {
                int limit = 0;
                if (scanner.hasNext()) {
                    limit = scanner.nextInt();
                }
                int champ = Integer.MAX_VALUE;
                for (int sum : sums) {
                    if ((Math.abs((sum - limit)) < Math.abs((champ - limit))) || (Math.abs((limit - sum)) < Math.abs((limit - champ)))) {
                        champ = sum;
                    }
                }
                System.out.println("Closest sum to " + limit + " is " + champ + ".");
            }
            nr_candidates = scanner.nextInt();
        }
        scanner.close();
    }

    public List<Integer> collect_candidates(int[] candidates) {
        List<Integer> sum = new ArrayList<Integer>();
        for (int i = 0; i < candidates.length; i++) {
            int[] options = candidates.clone();
            for (int j = 0; j < options.length; j++) {
                if (candidates[i] != options[j]) {
                    sum.add(candidates[i] + options[j]);
                }
            }
        }
        return sum;
    }
}

    /**
    public void CollectData2() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int loop = scanner.nextInt();
        ArrayList<Integer>[] limits = new ArrayList[1000];
        int count_numbers = 0;
        Boolean count = true;
        ArrayList<Integer>[] candidates = new ArrayList[1000];
        for (int i = 0; i < 1000; i++) {
            limits[i] = new ArrayList<Integer>();
            candidates[i] = new ArrayList<Integer>();
        }
        String input = scanner.nextLine();
        int case_nr = 1;
        while (count_numbers < loop) {
            count_numbers ++;
            input = scanner.nextLine();
            if (!input.isEmpty() && count) {
                candidates[case_nr].add(Integer.parseInt(input.replaceAll("\\s+","")));
            }
            if (!input.isEmpty() && !count) {
                limits[case_nr].add(Integer.parseInt(input.replaceAll("\\s+","")));
            }
            if (count_numbers == loop) {
                if (!count) {
                    case_nr ++;
                }
                String loop2 = scanner.nextLine().replaceAll("\\s+","");
                count = !count;
                if (loop2.isEmpty() || loop2.equals("0")) {
                    break;
                }
                loop = Integer.parseInt(loop2);
                count_numbers = 0;
            }
        }
        scanner.close();
        SolveProblem(candidates, limits);
    }

    public void SolveProblem(ArrayList<Integer>[] numbers, ArrayList<Integer>[] limits) {
        for(int i = 0; i < limits.length; i++) {
            if (!limits[i].isEmpty()) {
            System.out.println("Case " + i + ":");
                for(int j = 0; j < limits[i].size(); j++) {
                System.out.println("Closest sum to " + limits[i].get(j) + " is " + BestMatch(numbers[i], limits[i].get(j)) + ".");
                }
            }
        }
    }
    public Integer BestMatch(ArrayList<Integer> numbers, int limit) {
        int champ = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> options = (ArrayList<Integer>) numbers.clone();
            options.remove(i);
            for(int j = 0; j < options.size(); j++) {
                int contestant = numbers.get(i) + options.get(j);
                if ((Math.abs((contestant - limit)) < Math.abs((champ - limit))) || (Math.abs((limit - contestant)) < Math.abs((limit - champ)))){
                    champ = contestant;
                }
            }
        }
        return champ;
    }
     */
