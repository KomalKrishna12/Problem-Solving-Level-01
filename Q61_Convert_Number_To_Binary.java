import java.util.Scanner;

public class Q61_Convert_Number_To_Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        convertIntoBinary(num);
        scanner.close();
    }
    public static void convertIntoBinary(int num){
        String binary = "";
        while(num > 0){
            int rem = num % 2;
            num = num / 2;
            binary = rem  + binary;
        }
        System.out.println("Binary : " + binary);
    }
}
