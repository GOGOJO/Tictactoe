package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static char[][] insertArray(String input) {
        char[][] board = new char[3][3];

        char[] userInput = input.toCharArray();
        int counter = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = userInput[counter++];
            }
        }
        return board;
    }

    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int x = 0; x < 3; x++) {
            System.out.print("| ");
            for (int y = 0; y < 3; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkAvaliable(char[][] board, int x, int y) {
        if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
            return false;
        }
        return true;
    }

    public static String analyze(char[][] inputBoard) {
        char[][] board = inputBoard;
        int xCounter = 0;
        int oCounter = 0;
        int n = 3;
        boolean draw = true;
        boolean xwins = false;
        boolean owins = false;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == 'O') {
                    oCounter++;
                } else if (board[x][y] == 'X') {
                    xCounter++;
                }
            }
        }

        // check x horizontal
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != 'X') {
                break;
            }
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[1][i] != 'X') {
                break;
            }
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[2][i] != 'X') {
                break;
            }
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }

        // check X verticle
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 'X')
                break;
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][1] != 'X')
                break;
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][2] != 'X')
                break;
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }
        // check X diag
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != 'X') {
                break;
            }
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }
        // check X anti diag
        for (int i = 0; i < 3; i++) {
            if (board[i][n - 1 - i] != 'X') {
                break;
            }
            if (i == n - 1) {
                xwins = true;
                draw = false;
            }
        }

        // check O horizontal
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != 'O') {
                break;
            }
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[1][i] != 'O') {
                break;
            }
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[2][i] != 'O') {
                break;
            }
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }

        // check O verticle
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 'O')
                break;
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][1] != 'O')
                break;
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][2] != 'O')
                break;
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }
        // check O diag
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != 'O') {
                break;
            }
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }
        // check O anti diag
        for (int i = 0; i < 3; i++) {
            if (board[i][n - 1 - i] != 'O') {
                break;
            }
            if (i == n - 1) {
                owins = true;
                draw = false;
            }
        }

        if (draw && xCounter >= 5 && oCounter >= 4) {
            return "Draw";
        } else if (xwins) {
            return "X wins";
        } else if (owins) {
            return "O wins";
        }
        return "default";

    }

    public static char[][] move(char[][] inputboard, char i) {
        char[][] board = inputboard;
        boolean repeat = true;
        Scanner sc = new Scanner(System.in);
        int[] userCords = new int[2];

        while (repeat) {

            int x;
            int y;
            try {
                String input = sc.nextLine();
                String[] inputAry = input.split(" ");
                for (int j = 0; j < inputAry.length; j++) {

                    userCords[j] = Integer.parseInt(inputAry[j]);
                }
                x = userCords[0];
                y = userCords[1];

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (!checkAvaliable(board, x, y)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                repeat = false;
                board[x - 1][y - 1] = i;

            }
        }
        return board;
    }

    public static void main(String[] args) {
        boolean game = true;
        char[][] board = insertArray("         ");
        printBoard(board);

        while (game) {
            board = move(board, 'X');
            printBoard(board);

            switch (analyze(board)) {
                case "X wins":
                    System.out.println("X wins");
                    game = false;
                    continue;
                case "O wins":
                    System.out.println("O wins");
                    game = false;
                    continue;
                case "Draw":
                    System.out.println("Draw");
                    game = false;
                    continue;
                default:
                    System.out.print("");
            }

            board = move(board, 'O');
            printBoard(board);

            switch (analyze(board)) {
                case "X wins":
                    System.out.println("X wins");
                    game = false;
                    continue;
                case "O wins":
                    System.out.println("O wins");
                    game = false;
                    continue;
                case "Draw":
                    System.out.println("Draw");
                    game = false;
                    continue;
                default:
                    System.out.print("");
            }

        }

    }
}
