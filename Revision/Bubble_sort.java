import java.util.Scanner;

public class Bubble_sort{

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] bubblesort(int[] arr) {
        int[] sortedarr = new int[arr.length];
        return sortedarr;
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