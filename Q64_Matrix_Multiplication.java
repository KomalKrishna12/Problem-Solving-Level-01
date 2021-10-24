import java.util.Scanner;

public class Q64_Matrix_Multiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr1 = new int[n][m];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = scn.nextInt();
            }
        }
        int p = scn.nextInt();
        int q = scn.nextInt();
        int[][] arr2 = new int[p][q];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = scn.nextInt();
            }
        }
        scn.close();
        if(m != p){
            System.out.println("invalid input");
            return;
        }
    
        int[][] res = new int[n][q];
        for (int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[i].length; j++){
                for(int k = 0; k < m; k++){
                    res[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        scn.close();
    }
}
