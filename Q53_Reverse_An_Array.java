import java.util.Scanner;

public class Q53_Reverse_An_Array{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println("Before reverse : ");
        display(arr);
        reverse(arr);
        System.out.println("After reverse : ");
        display(arr);
    }

    public static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}