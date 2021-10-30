package recursion_on_the_way_up;

import java.util.Scanner;

public class Q7_Print_Encodings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        printEncoding(str);
        scanner.close();
    }
    public static void printEncoding(String str) {
        for (int i = 1; i < str.length(); i++) {
            String string = str.substring(0, i);
            for (int j = 0; j < string.length(); j++) {
            }
        }
    }
}
