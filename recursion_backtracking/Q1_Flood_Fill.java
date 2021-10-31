import java.util.Scanner;

public class Q1_Flood_Fill{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
        scn.close();
    }
    public static void floodfill(int[][] arr, int row, int col, String ans, boolean[][] visited) {
        if(row < 0 || col < 0 || arr.length == row || arr[0].length == col || 
        arr[row][col] == 1 || visited[row][col] == true){
            return;
        }

        if(row == arr.length - 1 && col == arr[0].length - 1){
            System.out.println(ans);
            return;
        }

        visited[row][col] = true;
        floodfill(arr, row - 1, col, ans + "t", visited);
        floodfill(arr, row, col - 1, ans + "l", visited);
        floodfill(arr, row + 1, col, ans + "d", visited);
        floodfill(arr, row, col + 1, ans + "r", visited);   
        visited[row][col] = false;
    }
}