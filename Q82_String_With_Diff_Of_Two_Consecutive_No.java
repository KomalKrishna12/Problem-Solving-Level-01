import java.util.*;
public class Q82_String_With_Diff_Of_Two_Consecutive_No{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
        scn.close();
    }
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        int gap = 0;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            gap = curr - prev;
            sb.append(gap);
            sb.append(curr);
        }
        return sb.toString();
    }
}