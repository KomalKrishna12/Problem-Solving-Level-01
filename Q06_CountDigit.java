import java.util.Scanner;

public class Q06_CountDigit {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int digit = 0;
        while(n > 0){
            n = n/10;
            digit++;
        }
        System.out.println("Digits in number : " + digit);
        scanner.close();

    }

}
