import java.util.Scanner;

public class Q72_Diagonal_Traversal_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        display(arr);
        diagonalTraversal(arr);
        scanner.close();
    }

    public static void diagonalTraversal(int[][] arr) {
        for(int g = 0; g < arr.length; g++){
            for(int i = g, j= 0; i < arr.length; i++,j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
