import java.util.Scanner;

public class Q3_N_Queens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        nQueens(arr, "", 0);
        scn.close();
    }

    public static void nQueens(int[][] arr, String ans, int row) {
        if (row == arr.length) {
            System.out.println(ans + ".");
            return;
        }

        for (int col = 0; col < arr.length; col++) {
            if (isPointASafePoint(arr,row,col) == true) {
                arr[row][col] = 1;
                nQueens(arr, ans + row + "-" + col + ", ", row + 1);
                arr[row][col] = 0;
            }
        }
    }
    public static boolean isPointASafePoint(int[][] arr, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if(arr[i][j] == 1)
            return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(arr[i][j] == 1)
            return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if(arr[i][j] == 1)
            return false;
        }
        return true;
    }
}
