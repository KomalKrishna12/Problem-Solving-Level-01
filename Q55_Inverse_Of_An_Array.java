import java.util.Scanner;

public class Q55_Inverse_Of_An_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("before inverse");
        display(arr);
        int[] in = inverse(arr);
        System.out.println("after inverse");
        display(in);
        scn.close();
    }
    public static int[] inverse(int[] arr){
        int[] inv = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            inv[v] = i;
        }
        return inv;
    }

    public static void display(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
