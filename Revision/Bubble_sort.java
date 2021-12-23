import java.util.Scanner;

public class Bubble_sort{

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] bubblesort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < arr.length - i; j++){
                if(isSmaller(arr, j + 1, j)){
                    swap(arr, j + 1, j);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSmaller(int[] arr, int i, int j){
        if(arr[i] < arr[j]){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int[] sorted = bubblesort(arr);
        display(sorted);
        scn.close();
    }
}