import java.util.Scanner;

public class Q13_Pythgorean_Triplet {
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        int max = a;
        if(max < b){
            max = b;
        }
        if(max < c){
            max = c;
        }

        if(max == a){
            System.out.println((a * a) == ((b * b) + (c * c)));
        }
        else if(max == b){
            System.out.println((b * b) == ((a * a) + (c * c)));
        }
        else{
            System.out.println((c * c) == ((b * b) + (a * a)));
        }
        scn.close();
    }
}
