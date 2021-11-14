import java.util.Scanner;

public class Q8_Coin_Change_Combination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        isboolean();
    }
    public static void isboolean() {
        System.out.println("boolean");
    }
}
