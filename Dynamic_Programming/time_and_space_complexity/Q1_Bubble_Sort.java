import java.util.*;
public class Q1_Bubble_Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        bubbleSort(arr);
        display(arr);
        scanner.close();
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i; j++){
                if(isSmall(arr,j+1,j)){
                    swap(arr,j+1,j);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean isSmall(int[] arr, int i, int j){
        if(arr[i] < arr[j]){
            return true;
        }
        else{
            return false;
        }
    }
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
