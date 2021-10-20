import java.util.Scanner;

public class Q18_Pattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = n; i >= 1; i--){
            for(int j=i; j >= 1; j--){
                System.out.print("*\t");
            }
            System.out.println();
        }
        scanner.close();
    }
}
