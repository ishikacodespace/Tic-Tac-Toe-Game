import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        // Initialize the game board
        int boardSize = 3;
        int a = 1; // to fill the board with numbers 1-9
        String[][] board = new String[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = (char) (a++ + '0') + "";
            }
        }

        // Print the initial game board
        printBoard(board);

        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 9; i++) {
            System.out.print("Enter your move on the board (1-9): ");
            int move = in.nextInt();
            System.out.println("You entered: " + move);
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            String playerMove = "";
            if (i % 2 == 0) {
                playerMove = "O";
            } else {
                playerMove = "X";
            }
            if (checkInvalidMove(board, row, col, playerMove)) {
                System.out.println("Invalid move! Try again.");
                i--; // to allow the same player to play again
                continue;
            } else {
                board[row][col] = playerMove;
            }
            printUpdatedBoard(board, row, col, playerMove);
            if (checkWin(board, playerMove)) {
                System.out.println("Player " + playerMove + " wins!");
                i = 10; // to exit the loop
                break;
            }
            if (i == 9) {
                System.out.println("It's a draw!");
            }
        }
    }

    // Print the initial empty board
    public static void printBoard(String[][] board) {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j] + "|");
            }
            // board[0][0] board[0][1] board[0][2]
            // board[1][0] board[1][1] board[1][2]
            // board[2][0] board[2][1] board[2][2]
            System.out.println();
        }
    }

    // Print the updated board after a player's move
    public static void printUpdatedBoard(String[][] board, int row, int col, String playerMove) {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == row && j == col) {
                    System.out.print("|" + playerMove + "|");
                } else {
                    System.out.print("|" + board[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    // Function to check if the current player has won
    public static boolean checkWin(String board[][], String playerMove) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(playerMove)
                    && board[i][1].equals(playerMove) &&
                    board[i][2].equals(playerMove)) {
                return true;
            }
        }
        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(playerMove)
                    && board[1][j].equals(playerMove) &&
                    board[2][j].equals(playerMove)) {
                return true;
            }
        }
        // check diagonals
        if (board[0][0].equals(playerMove)
                && board[1][1].equals(playerMove) &&
                board[2][2].equals(playerMove)) {
            return true;
        }
        if (board[0][2].equals(playerMove)
                && board[1][1].equals(playerMove) &&
                board[2][0].equals(playerMove)) {
            return true;
        }
        return false;
    }

    // Function to check invalid move
    public static boolean checkInvalidMove(String board[][], int row, int col, String playerMove) {
        if (board[row][col].equals("X") || board[row][col].equals("O")) {
            return true;
        }
        return false;
    }
}
