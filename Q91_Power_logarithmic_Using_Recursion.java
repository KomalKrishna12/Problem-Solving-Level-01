import java.util.Scanner;

public class Q91_Power_logarithmic_Using_Recursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(power(x,n));
        scn.close();
    }
    public static int power(int x, int n) {
        if(n==0){
            return 1;
        }
        int xpn2 = power(x, n/2);
        int xpn = xpn2 * xpn2;
        if(n%2==1){
            xpn *= x;
        }
        return xpn;
    }
}
