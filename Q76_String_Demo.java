import java.util.Scanner;

public class Q76_String_Demo{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // String s1 = scn.next();//next() will read till space occure.
        // String s2 = scn.next();
        // String s3 = scn.nextLine();//nextLine() will read whole line
        // String s4 = scn.nextLine();
        String s = scn.nextLine();
        System.out.println("String        : " + s);
        System.out.println("String length : " + s.length()); //length() is a function of String class
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println(i + " : " + ch);//charAt is used to take character from string
            // s.charAt(0) = 'z' won't work.. we cannot set any char to a string like we do in array
            //for this we use Stringbuilder class
        }
        System.out.println(s.substring(0, s.length()));
        //s.substring(1) it will print all char starting from index 1
        System.out.println(s.substring(1));

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j) + " ");
            }
        }
        String s1 = "hello";
        // String s2 = "world";
        // String s3 = s1 + s2;
        // // System.out.println(s3);//helloworld
        // s1 += ' ';
        // s1 += 'w';//we can add character into string
        // s1 += 10;//we can add integer also;

        System.out.println(s1 + 10 + 20);//first is string so 10 20 added as string
        System.out.println(10 + 20 + s1);// first is int so first sum then add into string
        String s5 = "abc-def-ghi jkl";
        String[] parts = s5.split("-");
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }
        scn.close();
    }
}