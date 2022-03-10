package recursion_on_the_way_up;

import java.util.Scanner;

public class Q7_Print_Encodings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //here we are receiving a string for which we want to encode
        String str = scanner.nextLine();
        printEncoding(str,"");
        scanner.close();
    }
    public static void printEncoding(String str, String ans) {
        //when string length becomes zero it'll print the ans
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //when string length becomes one so firstly we check for the character
        //if character is zero we simply return it
        //else we convert the char into integer and then get the char for the corresponding integer
        //and then we print the ans with adding the character 
        else if(str.length() == 1){
            char ch = str.charAt(0);
            if(ch == '0'){
                return;
            }
            else{
                int chv = ch - '0';
                char charV = (char)('a' + chv - 1);
                System.out.println(ans + charV);
            }
        }
        //when string length is greater than 1 we can have two cases - first we get one char 
        //(check that charater is not '0')and rest of str
        //will be string which we can get by using substring function

        //in second case we get string of length two for adding in ans and rest is substring
        //we change the string ch12 into integer then we apply a condition that the integer
        //must be less than or equal to 26
        //then change it to character and add that into ans to print in result
        else{
            char ch1 = str.charAt(0);
            String substr = str.substring(1);
            if(ch1 == '0'){
                return;
            }
            else{
                // suppose ch1 = 'c'
                // int code = 'c' - '0' = 3
                // so to convert 3 to character we can 'a' + code - 1
                // 'a' == 1
                // char = 1 + 3 - 1 = 3 
                int chv2 = ch1 - '0';
                char charV2 = (char)('a' + chv2 - 1);
                printEncoding(substr, ans + charV2);
            }

            String ch12 = str.substring(0,2);
            String substr12 = str.substring(2);
            int ch12i = Integer.parseInt(ch12);
            if(ch12i <= 26){
                char code = (char)('a' + ch12i - 1);
                printEncoding(substr12, ans + code);
            }
        }
    }
}
