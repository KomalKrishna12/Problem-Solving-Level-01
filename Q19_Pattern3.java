import java.util.Scanner;

public class Q19_Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //first approach
        // for(int i = 1; i <= n; i++){
        //     for(int j = n; j >= 1; j--){
        //         if(i < j){
        //             System.out.print("\t"); 
        //         }
        //         else{
        //             System.out.print("*\t");
        //         }
        //     }
        //     System.out.println();
        // }

        //second approach
        int sp = n-1;
        int st = 1;
        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }

            for(int j = 1; j <= st; j++){
                System.out.print("*\t");
            }

            sp--;
            st++;
            System.out.println();

        }
        scn.close();
    }
}
