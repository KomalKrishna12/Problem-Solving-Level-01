package recursion_on_the_way_up;

import java.util.*;

public class Q1_Print_Subsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printSubstring(str,"");
        //when we call this function first time then string ans is empty;
        scn.close();
    }
    public static void printSubstring(String str, String ans) {
        //when length is zero that means str is empty so no subsequences are ther so we print ans.
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //first we take first char from str
        //then we add rest substring in s so next time when we call printSubstring() next time we pass rest
        //substring in place of str so have two possibilities- one is we can add ch in ans and second is we 
        //don't add ch--- like if ans is bc and ch is a so two possibilites are abc and bc
        char ch = str.charAt(0);
        String s = str.substring(1);

        //in first call we are adding ch beacuse in output first string is not empty
        //in second call we add "" that means nothing so in last string we get empty string that means 
        //no char is printing 
        printSubstring(s, ans + ch);
        printSubstring(s, ans + "");
    }
}
