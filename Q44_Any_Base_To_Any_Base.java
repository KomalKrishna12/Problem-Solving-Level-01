import java.util.Scanner;

public class Q44_Any_Base_To_Any_Base {

    public static int getValueAtBase(int n, int b1, int b2){
        int dec = anyBaseToDecimal(n, b1);
        int dn = decimalToAnyBase(dec, b2);
        return dn;
    }

    public static int anyBaseToDecimal(int n, int b){
        int rv = 0;
        int pow = 1;
        while(n > 0){
            int dig = n % 10;
            n = n / 10;
            rv += dig * pow;
            pow *= b;
        }
        return rv;
    }

    public static int decimalToAnyBase(int n, int b){
        int rv = 0;
        int pow = 1;
        while(n > 0){
            int dig = n % b;
            n = n / b;
            rv += dig * pow;
            pow *= 10;
        }
        return rv;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();
        System.out.println(getValueAtBase(n,b1,b2));
        scanner.close();
    }
}
