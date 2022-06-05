// it is similar like get connected components but in form of 2D array
// so here we don't have edges we have values 0 and 1
// if value is 0 that means it is land and if it is 1 that means it is water
// to get nabour we use 4 directions using (i+1, j), (i-1, j), (i, j-1), (i, j+1)
import java.io.*;

public class Q7_Number_of_islands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        int count = 0;

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    countIslands(arr, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void countIslands(int[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] == 1 || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;
        countIslands(arr, i - 1, j, visited);
        countIslands(arr, i, j + 1, visited);
        countIslands(arr, i + 1, j, visited);
        countIslands(arr, i, j - 1, visited);
    }
}
