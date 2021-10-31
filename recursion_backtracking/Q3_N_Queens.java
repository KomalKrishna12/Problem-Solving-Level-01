import java.util.Scanner;

public class Q3_N_Queens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //here n is the input no for which we want to create chess with same row and same col that means
        //in a square shape
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        nQueens(arr, "", 0);
        scn.close();
    }

    public static void nQueens(int[][] arr, String ans, int row) {
        //when row == arr.length that means we're at out of index so we print the ans and return
        if (row == arr.length) {
            System.out.println(ans + ".");
            return;
        }

        //for one row we can have n columns
        //we check that the point is safe or not
        //if safe than we print 1 and again check for their corr col and after that print 0 
        for (int col = 0; col < arr.length; col++) {
            if (isPointASafePoint(arr,row,col) == true) {
                arr[row][col] = 1;
                nQueens(arr, ans + row + "-" + col + ", ", row + 1);
                arr[row][col] = 0;
            }
        }
    }
    public static boolean isPointASafePoint(int[][] arr, int row, int col) {
        //for first cond we check in the same col and row -1 if element is 1 that means one queen is there
        for (int i = row - 1, j = col; i >= 0; i--) {
            if(arr[i][j] == 1)
            return false;
        }
        //second cond is to check diagonal for which row = row - 1 & col = col - 1 and check for the queen
        //if queen is there than return false that means we cannot print queen there becoz it can cut another
        //queen
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(arr[i][j] == 1)
            return false;
        }
        //third cond is to check diagonal for which row = row -1 and col = col +1 and check for the queen 
        //availablity
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if(arr[i][j] == 1)
            return false;
        }
        return true;
    }
}
