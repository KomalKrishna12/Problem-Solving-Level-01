import java.util.Scanner;

public class Q43_Any_Base_To_Decimal {
    public static int getValueAtBase(int n, int b){
        int rv = 0;
        int power = 1;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            rv += d * power;
            power *= b;
        }
        return rv;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(getValueAtBase(n,b));
        scn.close();
    }
}
