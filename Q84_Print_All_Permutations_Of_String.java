import java.util.Scanner;

public class Q84_Print_All_Permutations_Of_String {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     String str = scanner.next();
     solution(str);
     scanner.close();
 }   

 public static void solution(String str) {
     int n = str.length();
     int f = fact(n);
     for(int i = 0; i < f; i++){
        StringBuilder sb = new StringBuilder(str);
         int temp = i;
         for(int div = n; div > 0; div--){
             int q = temp / div;
             int r = temp % div;
             System.out.print(sb.charAt(r));
             sb.deleteCharAt(r);
             temp = q;
         }
         System.out.println();
     }
 }

 public static int fact(int n) {
     int val = 1;
     for (int i = 2; i <= n; i++) {
         val *= i;
     }
     return val;
 }
}
