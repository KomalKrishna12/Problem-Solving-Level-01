import java.util.Scanner;

public class Q4_Knights_Tour{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n is the size of chess board row == column
        int n = scanner.nextInt();
        //row and col is the position where we want to place our knights first move
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, row, col, 1);
        scanner.close();
    }
    public static void printKnightsTour(int[][] chess, int row, int col, int move) {
        if(row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0){
            return;
        }
        //when move == chess legth * chess length that means it is the final and last move
        //so we place the value in the index and display the chess board and again place 0 in the place
        //so if there is another path so we can display that also
        if(move == chess.length * chess.length){
            chess[row][col] = move;
            displayChessBoard(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = move;
        //there are 8 options for the knight rider
        //first (row - 2, col + 1)
        //second (row - 1, col + 2)
        //third (row + 1, col + 2)
        //fourth (row + 2, col + 1)
        //fifth (row + 2, col - 1)
        //sixth (row + 1, col - 2)
        //seventh (row - 1, col - 2)
        //eighth (row - 2, col - 1) 
        printKnightsTour(chess, row-2, col+1, move+1);
        printKnightsTour(chess, row-1, col+2, move+1);
        printKnightsTour(chess, row+1, col+2, move+1);
        printKnightsTour(chess, row+2, col+1, move+1);
        printKnightsTour(chess, row+2, col-1, move+1);
        printKnightsTour(chess, row+1, col-2, move+1);
        printKnightsTour(chess, row-1, col-2, move+1);
        printKnightsTour(chess, row-2, col-1, move+1);
        chess[row][col] = 0;
    }
    public static void displayChessBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}