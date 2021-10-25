import java.util.Scanner;

public class Q74_Linear_Search_In_2D_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int data = scanner.nextInt();
        display(arr);
        linearSearch(arr, data);
        scanner.close();
    }

    public static void linearSearch(int[][] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == data){
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
        System.out.println("Not found!");
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
