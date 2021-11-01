import java.util.Scanner;

public class Q2_Selection_Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        selectionSort(arr);
        display(arr);
        scanner.close();
    }

    //this function is used to display array element
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //firstly we store i value to min var then perform comparison 
            //if found any smaller value then min var will point to that index
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (isSmallest(arr, j, min)) {
                    min = j;
                }
            }
            //here we swap min with i
            swap(arr, i, min);
        }
    }

    //this is the function to check the smallest element by comparing both arr[i] and arr[j]
    public static boolean isSmallest(int[] arr, int j, int i) {
        System.out.println("comparing " + arr[j] + " with " + arr[i]);
        if (arr[j] < arr[i]) {
            return true;
        } else {
            return false;
        }
    }

    //this is function to swap value of arr[i] and arr[j]
    public static void swap(int[] arr, int j, int i) {
        System.out.println("Swaping " + arr[j] + " with " + arr[i]);
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
