package recursion_on_the_way_up;
import java.util.Scanner;

public class Q2_Print_KPC{
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str, "");
        scn.close();
    }

    public static void printKPC(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String subString = str.substring(1);
        String code = codes[ch - '0'];
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            printKPC(subString, ans + c);
        }
    }

}