import java.util.Scanner;
//in this question we have n fences and k colurs
//we have to paint n fences with k colours so that not more than two consecutive fences will be
//painted with the same colours
public class Q19_Paint_Fence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        //for two fences if we want to colure same then there is k * 1 ways
        //suppose we k = 3 for and colors are red, blue, green if first fence color is red then for 2nd fence
        //it has to color with same red for same so same = 3 * 1;
        //for diff if first one colour with red then ways for secnd will be (k-1)
        //calculating total beacuse in next iteration for diff we have (k-1) choices for second fence
        //so diff = total *(k-1)
        //and same will be same as diff and there is only one way to be same that choose same color
        //which is in last diff fence
        //so same = diff * 1;
        int same = k * 1;
        int diff = k * (k-1);
        int total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff * 1;
            diff = total * (k-1);
            total = same + diff;
        }
        //at last we print total that contains total no of ways which is summation of having last two fence
        //same and last two fence different
        System.out.println(total);
        scn.close();
    }
}
