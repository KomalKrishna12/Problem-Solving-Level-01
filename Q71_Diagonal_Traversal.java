import java.util.Scanner;

public class Q71_Diagonal_Traversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        diagonalTraversal(arr, n);
        scanner.close();
    }

    public static void diagonalTraversal(int[][] arr, int n) {
        for (int g = 0; g < arr.length; g++) {
    
            for(int i = 0, j = g; j < arr.length; i++,j++){
                System.out.println(arr[i][j]);
            }

        }
    }
}
