import java.util.Scanner;

public class Q46_Any_Base_Difference {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        System.out.println(getDifference(b,n1,n2));
        scn.close();
    }
    public static int getDifference(int b, int n1, int n2){
        int rev = 0;
        int c = 0;
        int pow = 1;
        while(n2>0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 /10;
            int d = 0;
            d2 = d2 + c;
            if(d2>=d1){
                c=0;
                d=d2-d1;
            }
            else{
                c=-1;
                d=d2+b-d1;
            }
            rev += d * pow;
            pow *= 10;
        }
        return rev;
    }
}
