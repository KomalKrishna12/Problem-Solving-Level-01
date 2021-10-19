import java.util.Scanner;

public class Q15_Rotate_A_Number {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int nod = 0;
        int temp = n;
        while(temp != 0){
            temp = temp/10;
            nod++;
        }

        k = k % nod;
        if(k < 0){
            k = k + nod;
        }
        int div = 1;
        int mul = 1;

        for(int i = 1; i <= nod; i++){
            if(i <= k){
                div = div*10;
            }
            else{
                mul = mul*10;
            }
        }
        int q = n/div;
        int r = n%div;
        int rev = r*mul + q;
        System.out.println(rev);
        scanner.close();

    }

}
