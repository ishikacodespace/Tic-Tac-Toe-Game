import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        // Additional game logic would go here
        int boardSize = 3;
        int a=1;
        char[][] board=new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = (char) (a++ + '0');
            }
        }
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your move on the board (1-9): ");
        char move=in.next().charAt(0);
        switch (move) {
            case '1':
                board[0][0] = 'X';
                break;

            default:
                break;
        }
        
    }
}
