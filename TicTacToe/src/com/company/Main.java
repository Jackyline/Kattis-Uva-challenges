package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        final Scanner scanner = new Scanner(System.in);

        int test_cases = Integer.parseInt(scanner.nextLine());

        while (test_cases != 0) {
            String solution = validBoard(scanner, test_cases);
            System.out.println(solution);
            test_cases--;
        }
        scanner.close();
    }

    public String validBoard(Scanner scanner, int nr) {
        Boolean valid = true;
        List<String> board = new ArrayList<String>();
        String first_row = scanner.nextLine();
        String sec_row = scanner.nextLine();
        String third_row = scanner.nextLine();
        board.add(first_row);
        board.add(sec_row);
        board.add(third_row);
        int Os = 0;
        int Xs = 0;
        for (String row: board) {
            Os += row.length() - row.replace("O", "").length();
            Xs += row.length() - row.replace("X", "").length();
        }
        //empty line
        if (nr > 1) {
            if(scanner.hasNext()){
                String empty = scanner.nextLine();
            }
        }
        return winner(board, Xs, Os);
    }

    public String winner(List<String> board, int xSum, int oSum) {
        char[][] ar_board = new char[3][3];
        int Xs = 0;
        int Os = 0;
        //Check row in
        Boolean xWin = false;
        Boolean oWin = false;
        for (String row: board) {
            Os = row.length() - row.replace("O", "").length();
            Xs = row.length() - row.replace("X", "").length();
            if (Os == 3) {
                oWin = true;
            }
            if (Xs == 3) {
                xWin = true;
            }
        }
        if(xWin && oWin) {
            return "no";
        }
        if(oWin && !xWin && xSum > oSum) {
            return "no";
        }
        if(xWin && !oWin && xSum == oSum) {
            return "no";
        }
        //X win on row and no over step on rule
        if (xWin && !oWin && Xs == 3 && xSum == (oSum + 1)) {
            return "yes";
        }
        //O win on row and no over step on rule
        if (oWin && !xWin && Os == 3 && xSum == oSum) {
            return "yes";
        }
        //Collect board in 3 times 3 array
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                ar_board[i][j] = board.get(i).charAt(j);
            }
        }
        oWin = false;
        xWin = false;
        //Check winner in col
        for(int i=0; i<=2; i++) {
            Os = 0;
            Xs = 0;
            for(int j=0; j<=2; j++) {
                if (ar_board[j][i] == 'X'){
                    Xs += 1;
                }
                if (ar_board[j][i] == 'O'){
                    Os += 1;
                }
            }
            if (Xs == 3) {
                xWin = true;
            }
            if (Os == 3) {
                oWin = true;
            }
        }
        if(xWin && oWin) {
            return "no";
        }
        if(xWin && !oWin && xSum == oSum) {
            return "no";
        }
        if(oWin && !xWin && xSum > oSum) {
            return "no";
        }
        //X win on col and no over step on rule
        if (xWin && !oWin && Xs == 3 && xSum == (oSum + 1)) {
            return "yes";
        }
        //O win on col and no over step on rule
        if (oWin && !xWin && Os == 3 && xSum == oSum) {
            return "yes";
        }

        //X win on right diag
        if (ar_board[0][0] == 'X' && ar_board[0][0] == ar_board[1][1] && ar_board[1][1] == ar_board[2][2]) {
            if (xSum == (oSum+1)) {
                return "yes";
            }
            else if (xSum == oSum) {
                return "no";
            }
        }
        //O win on right diag
        if (ar_board[0][0] == 'O' && ar_board[0][0] == ar_board[1][1] && ar_board[1][1] == ar_board[2][2]) {
            if (xSum == oSum) {
                return "yes";
            }
            else {
                return "no";
            }
        }
        //X win on left diag
        if (ar_board[0][2] == 'X' && ar_board[0][2] == ar_board[1][1] && ar_board[1][1] == ar_board[2][0]) {
            if (xSum == (oSum+1)) {
                return "yes";
            }
            else if (xSum == oSum) {
                return "no";
            }
        }
        //O win on left diag
        if (ar_board[0][2] == 'O' && ar_board[0][2] == ar_board[1][1] && ar_board[1][1] == ar_board[2][0]) {
            if (xSum == oSum) {
                return "yes";
            }
            else {
                return "no";
            }
        }
        if (xSum == oSum || xSum == (oSum+1)) {
            return "yes";
        }
        return "no";
    }
}
