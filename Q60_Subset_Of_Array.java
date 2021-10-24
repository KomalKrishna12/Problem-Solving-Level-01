//first we calculate limit i.e 2 pow arr.length, then we start loop from 0 to limit, convert index to binary
//then start loop for element if remainder is 0 print "-" else print no.
import java.util.Scanner;

public class Q60_Subset_Of_Array{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int limit = (int)Math.pow(2, arr.length);
        for(int i = 0; i < limit; i++){
            int temp = i;
            String set = "";
            for (int j = arr.length - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;
                if(r == 0)
                set = "-\t" + set;
                else
                set = arr[j] + "\t" + set;
            }
            System.out.println(set);
        }
        scn.close();
    }
}