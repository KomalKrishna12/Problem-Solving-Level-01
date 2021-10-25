import java.util.Scanner;

public class Q67_Spiral_Traversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int minRow = 0;
        int minColumn = 0;
        int maxRow = arr.length - 1;
        int maxColumn = arr[0].length - 1;
        int total = n * m;
        int count = 0;
        while(count < total){
            //left wall
            for(int i = minRow, j = minColumn; i <= maxRow && count < total; i++){
                System.out.println(arr[i][j]);
                count++;
            }
            minColumn++;

            //bottom wall
            for(int i = maxRow, j = minColumn; j <= maxColumn && count < total; j++){
                System.out.println(arr[i][j]);
                count++;
            }
            maxRow--;

            //right wall
            for(int i = maxRow, j = maxColumn; i >= minRow && count < total; i--){
                System.out.println(arr[i][j]);
                count++;
            }
            maxColumn--;

            //top wall
            for(int i = minRow, j = maxColumn; j >= minColumn && count < total; j--){
                System.out.println(arr[i][j]);
                count++;
            }
            minRow++;

        }
        scn.close();
    }
}
