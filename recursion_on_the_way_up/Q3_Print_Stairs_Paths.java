package recursion_on_the_way_up;

import java.util.Scanner;

public class Q3_Print_Stairs_Paths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //n is the number represenating number of stairs 
        //firstly we send n and blank string in printStairsPath bcoz at first we are not going anywhere
        printStairsPaths(n, "");
        scn.close();
    }
    public static void printStairsPaths(int n, String path) {
        //when n is zero that means you are at destination now print the path
        if(n == 0){
            System.out.println(path);
            return;
        }
        //when n becomes negetive that means the way is wrong so simply return from the path
        if(n < 0){
            return;
        }
        //here we are doing recursion so when we get result of n-1 so we add 1 in the n and get the result
        printStairsPaths(n-1, path + 1);
        printStairsPaths(n-2, path + 2);
        printStairsPaths(n-3, path + 3);
    }
}
