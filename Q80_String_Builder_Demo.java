import java.util.Scanner;

public class Q80_String_Builder_Demo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("hello");
        sb.append("world"); //it will add char or string at end
        sb.append('!');
        System.out.println(sb.charAt(1));//print char at index 1
        System.out.println(sb);
        sb.setCharAt(1, 'c');//replace index 1 with 'c'
        System.out.println(sb);
        sb.insert(1, 'b');
        System.out.println(sb);
        sb.deleteCharAt(1);
        System.out.println(sb);
        sb.setCharAt(1, 'e');
        System.out.println(sb);
        scn.close();
    }
}
