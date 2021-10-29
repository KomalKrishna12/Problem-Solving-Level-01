package recursion_on_the_way_up;
import java.util.Scanner;

public class Q2_Print_KPC{
    //this is the String[] array of nokia key pad strings.
    //0 - > ".;"    
    //1 - > "abc"
    //2 - > "def"
    //3 - > "ghi"
    //4 - > "jkl"
    //5 - > "mno"
    //6 - > "pqrs"
    //7 - > "tu"
    //8 - > "vwx"
    //9 - > "yz"
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();  //here we receive string like "78"
        //so we want to print all subsequences of this string
        //like 7 - > "tu" and 8 - > "vwx"
        //all subsequences are "tv", "tw", "tx", "uv", "uw", "ux"
        printKPC(str, "");
        //calling printKPC() -> passing str in source and n ans empty string
        scn.close();
    }

    public static void printKPC(String str, String ans) {
        //if string is empty then there is no subsequences
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //firstly we exclude first char from str
        //then rest string we include in substring by passing one in substring() function
        char ch = str.charAt(0);
        String subString = str.substring(1);

        //now we get string which is present at char ch but it is available in string format but we want to
        //fetch index value which is integer so we subtract '0' it value is 48 when we subtract 48 from any
        //char it will convert that char into int
        String code = codes[ch - '0'];

        //now we add each char of string code into ans string and pass substring in place of str and send
        //ans + ch in place of ans 
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            printKPC(subString, ans + c);
        }
    }

}