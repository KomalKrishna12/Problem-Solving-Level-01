import java.util.Scanner;

public class Q93_Display_Array_Using_Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        displayArr(arr, 0);
        scanner.close();
    }
    public static void displayArr(int[] arr, int index) {
        if(index == arr.length){
            return;
        }
        System.out.println(arr[index]);
        displayArr(arr, index + 1);
    }
}
