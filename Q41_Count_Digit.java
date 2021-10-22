import java.util.Scanner;

public class Q41_Count_Digit{

    public static int countDigit(int n, int d){
        int count = 0;
        int temp = n;
        while(temp!=0){
            int t = temp%10;
            if(t==d)
            count++;
            temp = temp/10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();

        int count = countDigit(n, d);
        System.out.println("Count of " + d + " in " + n + " : " + count);

        scn.close();
    }
}
