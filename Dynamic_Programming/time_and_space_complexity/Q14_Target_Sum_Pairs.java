import java.util.Arrays;
import java.util.Scanner;

public class Q14_Target_Sum_Pairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPairs(arr, target);
        scn.close();
    }

    public static void targetSumPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int li = 0;
        int ri = arr.length - 1;
        while (li < ri) {
            if (arr[li] + arr[ri] < target) {
                li++;
            } else if (arr[li] + arr[ri] > target) {
                ri--;
            }
            else{
                System.out.println(arr[li] + ", " + arr[ri]);
                li++;
                ri--;
            }
        }
    }
}
