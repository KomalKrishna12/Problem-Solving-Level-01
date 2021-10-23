import java.util.Scanner;

public class Q45_Any_Base_Addition{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        System.out.println(getValue(b,n1,n2));
        scn.close();
    }
    public static int getValue(int b, int n1, int n2){
        int rv = 0;
        int c = 0;
        int pow = 1;
        while(n1>0 || n2>0 || c>0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            int d = d1 + d2 + c;
            c = d / b;
            d = d % b;
            rv += d * pow;
            pow *= 10;
        }
        return rv;
    }
}