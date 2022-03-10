package recursion_on_the_way_up;

import java.util.Scanner;

public class Q6_Print_Permutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //this is the string for which we want to print all permutations
        //if str is "abc"
        //permutations will be - "abc", "acb", "bac", "bca", "cab", "cba"
        String str = scn.next();

        //first time we pass str(abc) and ans will be empty 
        printPermutations(str, "");
        scn.close();
    }
    public static void printPermutations(String str, String ans) {

        //this is the base case when length of string become zero that means we can't perform recursion
        //anymore so we'll print the string and which is generated during the recursion process
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //here we pass loop for i = 0 to length - 1 so we can single character which we can add in ans
        //then we have to calculate substring for that we calculate left substring till i and right substring 
        //from i+1 then we merge both string and then pass that rest string in place of str
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //leftstr substring means here we save substring till i-1 and in right substring after ith place
            String leftStr = str.substring(0, i);
            String rightStr = str.substring(i+1);
            String rest = leftStr + rightStr;
            printPermutations(rest, ans + ch);
        }
    }
}
