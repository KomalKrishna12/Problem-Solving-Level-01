import java.util.Scanner;
//greedy approach
//when we include  first element then include will become arr[0]
//when we exclude first element then exclude will become 0
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
        //then create a loop from one to n
        //newInclude will become summation of exclude and arr[i]
        //newExclude will become max of include and exclude
        //explanation -
        //when first time we include then next time we exclude the item so we simply add exclude and arr[i]
        //when first time we exclude then next time we can include or exclude both ways so we take 
        //max of exclude and include
        for (int i = 1; i < arr.length; i++) {
            int newInclude = exculde + arr[i];
            int newExclude = Math.max(include, exculde);

            include = newInclude;
            exculde = newExclude;
        }
        //at end and will be max of exclude and include that will become the ans
        int ans = Math.max(include, exculde);
        System.out.println(ans);
        scn.close();
    }
}
