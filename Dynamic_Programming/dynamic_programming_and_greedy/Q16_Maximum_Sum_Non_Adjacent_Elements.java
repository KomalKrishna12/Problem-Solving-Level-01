import java.util.Scanner;

public class Q16_Maximum_Sum_Non_Adjacent_Elements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int include = arr[0];
        int exculde = 0;
        for (int i = 1; i < arr.length; i++) {
            int newInclude = exculde + arr[i];
            int newExclude = Math.max(include, exculde);

            include = newInclude;
            exculde = newExclude;
        }
        int ans = Math.max(include, exculde);
        System.out.println(ans);
        scn.close();
    }
}
