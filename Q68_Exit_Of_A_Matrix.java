//we have a matrix of n*m and elements are 0'2 & 1's if we start from i = 0 & j = 0 if next element
//is 0 then direction will ove in same direction if 1 then it will rotate by 90
//east(j++), west(j--), north(i--) and south(i++)
import java.util.Scanner;

public class Q68_Exit_Of_A_Matrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int dir = 0;
        int i = 0;
        int j = 0;
        while(true){
            dir = (dir + arr[i][j]) % 4;
            if(dir == 0){
                j++;
            }
            else if(dir == 1){
                i++;
            }
            else if(dir == 2){
                j--;
            }
            else if(dir == 3){
                i--;
            }
            if(i < 0){
                i++;
                break;
            }
            else if(j < 0){
                j++;
                break;
            }
            else if(i == arr.length){
                i--;
                break;
            }
            else if(j == arr[0].length){
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
        scn.close();
    }
}
