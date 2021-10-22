import java.util.Scanner;

public class Q40_nPr {

    public static int fact(int x){
        int rv = 1;

        for(int i = 1; i <= x; i++){
            rv*=i;
        }

        return rv;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        
        int nFact = fact(n);

        int nmrFact = fact(n-r);

        int nPr = nFact/nmrFact;
        System.out.println(n + "P" + r + " = " + nPr);

        scn.close();
    }

}
