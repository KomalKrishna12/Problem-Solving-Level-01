import java.util.*;
public class Q82_String_With_Diff_Of_Two_Consecutive_No{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
        scn.close();
    }
    public static String solution(String str) {
        String s = str.charAt(0) + "";
        int diff = 0;
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            char pre = str.charAt(i-1);
            diff = cur - pre;
            s = s + diff + cur;
        }
        return s;
    }
}