import java.util.Scanner;

public class ReversePrintNo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int no = scn.nextInt();
        while(no != 0){
            int r = no % 10;
            System.out.println(r);
            no = no / 10;
        }
        scn.close();
    }
}
