import java.util.Scanner;

public class Q3_Insertion_Sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        insertionSort(arr);
        print(arr);
        scn.close();
    }
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swaping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(isGreater(arr, j, j + 1)){
                    swap(arr, j, j + 1);
                }
                else{
                    break;
                }
            }
        }
    }
    public static boolean isGreater(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if(arr[i] > arr[j]){
            return true;
        }
        else{
            return false;
        }
    }
}
