package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().collectData();
    }

    public void collectData() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_cases = Integer.parseInt(scanner.nextLine());
        int cargo = 0;
        int travel_time = 0;
        int cars = 0;

        for(int i = 0; i < test_cases; ++i) {
            cargo = scanner.nextInt();
            travel_time = scanner.nextInt();
            int n_cars = scanner.nextInt();
            LinkedHashMap<Pair<String, Integer>, List<Integer>> order = new LinkedHashMap<Pair<String, Integer>, List<Integer>>();
            List<Integer> cars_left = new ArrayList<Integer>();
            List<Integer> cars_right = new ArrayList<Integer>();
            for(int j = 0; j < n_cars; ++j) {
                int time = scanner.nextInt();
                String pos = scanner.next();
                Pair<String, Integer> key = new Pair<String, Integer>(pos, time);
                List<Integer> start = new ArrayList<Integer>();
                start.add(0);
                if(order.containsKey(key)){
                    start = order.get(key);
                    start.add(0);
                    order.put(key, start);
                }
                if(!order.containsKey(key)){
                    order.put(key, start);
                }
                if (pos.equals("left")) {
                    cars_left.add(time);
                }
                else if(pos.equals("right")) {
                    cars_right.add(time);
                }
            }
            Collections.sort(cars_left);
            Collections.sort(cars_right);
            solveProblem(cars_left, cars_right, cargo, travel_time, order);
            for (Map.Entry mapElement : order.entrySet()) {

                List<Integer> value = (List<Integer>) mapElement.getValue();
                for (int end: value) {
                    System.out.println(end);
                }
            }
            if(i != test_cases - 1) {
                System.out.print("\n");
            }
        }
        scanner.close();
    }
    public void solveProblem(List<Integer> cars_left, List<Integer> cars_right, int cargo, int travel_time, LinkedHashMap<Pair<String, Integer>, List<Integer>> order) {
        int current_time = 0;
        List<Integer> cars_on_cargo = new ArrayList<Integer>();
        while(!(cars_left.size() == 0 && cars_right.size() == 0)) {
        //LEFT SIDE
        if(cars_left.size() > 0){
            for(int i = 0; i < cargo; ++i){
                if(i < cars_left.size()) {
                    if(cars_left.get(i) <= current_time) {
                        cars_on_cargo.add(cars_left.get(i));
                    }
                    if(cars_right.size() > 0) {
                        if(cars_left.get(0) >= current_time && cars_left.get(0) <= cars_right.get(0) && cars_on_cargo.size() == 0) {
                            cars_on_cargo.add(cars_left.get(0));
                            current_time = cars_left.get(0);
                        }
                        else if(cars_on_cargo.size() == 0 && cars_right.get(0) >= current_time){
                            current_time = cars_right.get(0);
                            break;
                        }
                    }
                    if(cars_right.size() == 0) {
                        if (cars_left.get(i) >= current_time && cars_on_cargo.size() == 0) {
                            cars_on_cargo.add(cars_left.get(0));
                            current_time = cars_left.get(0);
                        }
                    }
                    if (cars_left.get(i) >= current_time && cars_on_cargo.size() != 0 && !cars_on_cargo.contains(cars_left.get(i))) {
                        break;
                    }
                }
            }
        }
        else if(cars_left.size() == 0) {
            if (current_time < cars_right.get(0)) {
                current_time = cars_right.get(0);
            }
        }
        current_time += travel_time;
        //Remove cars that got transported
            int index = 0;
            for (int i: new ArrayList<Integer>(cars_on_cargo)) {
                if(cars_left.size() > 0) {
                    insertKey("left", i, order, current_time);
                    cars_left.remove(cars_left.indexOf(i));
                    index ++;
                }
                //System.out.println(current_time);

            }
        cars_on_cargo.clear();
        //RIGHT SIDE
        if (cars_right.size() > 0) {
            for(int k = 0; k < cargo; ++k) {
                if(k < cars_right.size()) {
                    if(cars_right.get(k) <= current_time) {
                        cars_on_cargo.add(cars_right.get(k));
                    }
                    if (cars_left.size() > 0) {
                        if(cars_right.get(0) >= current_time && cars_right.get(0) <= cars_left.get(0) && cars_on_cargo.size() == 0) {
                            cars_on_cargo.add(cars_right.get(0));
                            current_time = cars_right.get(0);
                        }
                        else if(cars_on_cargo.size() == 0 && cars_left.get(0) >= current_time){
                            current_time = cars_left.get(0);
                            break;
                        }
                    }
                    if(cars_left.size() == 0) {
                        if (cars_right.get(k) >= current_time && cars_on_cargo.size() == 0) {
                            cars_on_cargo.add(cars_right.get(k));
                            current_time = cars_right.get(k);
                        }
                    }
                    if (cars_right.get(k) >= current_time && cars_on_cargo.size() != 0 && !cars_on_cargo.contains(cars_right.get(k))) {
                        break;
                    }
                }
            }
        }
        else if(cars_right.size() == 0) {
            if (cars_left.size() != 0) {
                if (current_time < cars_left.get(0)) {
                    current_time = cars_left.get(0);
                }
            }
        }
        current_time += travel_time;
        //Remove cars that got transported
        index = 0;
        for (int i: new ArrayList<Integer>(cars_on_cargo)) {
            if(cars_right.size() > 0){
                insertKey("right", i, order, current_time);
                cars_right.remove(cars_right.indexOf(i));
                index ++;
            }
            //System.out.println(current_time);

        }
        cars_on_cargo.clear();
        }
    }

    public void insertKey(String pos, Integer time, LinkedHashMap<Pair<String, Integer>, List<Integer>> order, Integer end_time) {
        Pair<String, Integer> key = new Pair<String, Integer>(pos, time);
        if(order.containsKey(key)){
            if(order.get(key).size() == 1) {
                order.get(key).set(0, end_time);
            }
            if(order.get(key).size() > 1) {
                for(int i = 0; i < order.get(key).size(); ++i) {
                    if(order.get(key).get(i) == 0) {
                        order.get(key).set(i,end_time);
                        break;
                    }
                }
            }
        }
    }
}
class Pair<U, V>
{
    public final U first;   	// first field of a Pair
    public final V second;  	// second field of a Pair

    // Constructs a new Pair with specified values
    Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    // Checks specified object is "equal to" current object or not
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        // call equals() method of the underlying objects
        if (!first.equals(pair.first))
            return false;
        return second.equals(pair.second);
    }

    @Override
    // Computes hash code for an object to support hash tables
    public int hashCode()
    {
        // use hash codes of the underlying objects
        return 31 * first.hashCode() + second.hashCode();
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}