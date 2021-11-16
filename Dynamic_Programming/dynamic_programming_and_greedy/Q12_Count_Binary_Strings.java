import java.util.Scanner;

public class Q12_Count_Binary_Strings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //for size one string can be 0 (with ends with 0's) and 1(with ends with 1's) that means size is 1
        //we create loop from i = 2 and ends with i <= n

        //FIRST APPROACH
        // int oldCountZeros = 1;
        // int oldCountOnes = 1;
        // for (int i = 2; i <= n; i++) {
        //     //newCountZeros will be oldCountOnes because we don't want that string which contains 
        //     //no consecutives zeros so we simply transfer old zero count to new zero count
        //     //newCountZero will be addition of old count zero and old count one
        //     int newCountZeros = oldCountOnes;
        //     int newCountOnes = oldCountOnes + oldCountZeros;

        //     oldCountOnes = newCountOnes;
        //     oldCountZeros = newCountZeros;
        // }
        // System.out.println(oldCountOnes + oldCountZeros);

        //SECOND APPROACH
        int[] oldZeros = new int[n + 1];
        int[] oldOnes = new int[n + 1];
        oldZeros[1] = 1;
        oldOnes[1] = 1;
        for (int i = 0; i < oldOnes.length; i++) {
            oldOnes[i] = oldOnes[i - 1] + oldZeros[i - 1];
            oldZeros[i] = oldOnes[i - 1];
        }
        System.out.println(oldZeros[n] + oldOnes[n]);
        scn.close();
    }
}
