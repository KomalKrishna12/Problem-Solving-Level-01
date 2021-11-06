import java.util.Scanner;

public class Q12_Sort_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        sort(arr);
        print(arr);
        scanner.close();
    }
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + i + " and " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort(int[] arr) {
        int i = 0;
        int j = 0;
        while(i < arr.length){
            if(arr[i] == 1){
                i++;
            }
            else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
