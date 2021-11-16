import java.util.Scanner;

public class Q12_Count_Binary_Strings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int oldCountZeros = 1;
        int oldCountOnes = 1;
        for (int i = 2; i <= n; i++) {
            int newCountZeros = oldCountOnes;
            int newCountOnes = oldCountOnes + oldCountZeros;

            oldCountOnes = newCountOnes;
            oldCountZeros = newCountZeros;
        }
        System.out.println(oldCountOnes + oldCountZeros);
        scn.close();
    }
}
