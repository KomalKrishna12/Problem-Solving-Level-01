import java.util.Scanner;

public class Q42_Decimal_to_Any_Base {

    public static int getValueInBase(int n, int b){
        int rv = 0;
        int power = 1;
        while(n > 0){
            int d = n % b;
            n = n / b;
            rv += d *power;
            power *= 10;
        }
        return rv;
    }
 
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(getValueInBase(n, b));
        scn.close();

    }
    
}
