//size = 3 * 4
//arr -> 11  12  13  14
//       21  22  23  24
//       31  32  33  34
//path -> 11-21-31-32-22-12-13-23-33-34-24-14
//here first loop will be for column 0 to 3
//when j is even second loop will be for row 0 to 3
//when j is odd second loop will be for row 3 to 0
import java.util.Scanner;

public class Q65_Wave_Traversal{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        for (int j = 0; j < arr[0].length; j++) {
            if(j % 2 == 0){
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i][j]);
                }
            }
            else{
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
        scn.close();
    }
}