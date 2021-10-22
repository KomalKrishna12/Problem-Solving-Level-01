import java.util.Scanner;

public class Q37_Pattern21 {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 || i == n){
                    System.out.print("*\t");
                }
                else if(i < n){
                    if(j == 1 || j == n){
                        System.out.print("*\t");
                    }
                    else{
                        System.out.print("\t");
                    }
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        scn.close();

    }

}
