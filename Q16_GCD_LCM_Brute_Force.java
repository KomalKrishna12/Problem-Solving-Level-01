import java.util.Scanner;

public class Q16_GCD_LCM_Brute_Force{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int on1 = n1;   // here we are saving n1 and n2 original value in on1 and on2 variable so we can use
        int on2 = n2;   // these values in calculating LCM 
        while(n1 % n2 != 0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }               
        int gcm = n2;
        int lcm = (on1 * on2) / gcm;
        System.out.println("GCM of " + on1 + " & " + on2 + " is : " + gcm);
        System.out.println("LCM of " + on1 + " & " + on2 + " is : " + lcm);
        scn.close();
     }
}