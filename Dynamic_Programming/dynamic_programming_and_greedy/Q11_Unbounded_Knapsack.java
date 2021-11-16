import java.util.Scanner;

public class Q11_Unbounded_Knapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = scn.nextInt();
        }
        for (int i = 0; i < weight.length; i++) {
            weight[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        scn.close();
    }
}
