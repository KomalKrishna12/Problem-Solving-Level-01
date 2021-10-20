import java.util.Scanner;

public class Q12_Prime_Factorization_Of_A_Number {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        for(int div = 2; div * div <= n; div++){
            while(n % div == 0){
                n = n / div;
                System.out.print(div + " ");
            }
        }
        if(n != 0){
            System.out.print(n);  // if n is not zero then it must be last prime factor of a number
        }
        scn.close();

    }

}
