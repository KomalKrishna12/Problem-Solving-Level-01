import java.util.Scanner;

public class Q94_Display_Array_reverse_Using_Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        displayArrReverse(arr, 0);
        scanner.close();
    }
    public static void displayArrReverse(int[] arr, int index) {
        if(index == arr.length){
            return;
        }
        
        displayArrReverse(arr, index + 1);
        System.out.println(arr[index]);
    }
}
