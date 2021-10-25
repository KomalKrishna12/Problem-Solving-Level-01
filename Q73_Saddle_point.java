//sadle point is a value which is least in the column and max in the row
//there can be only one saddle point a 2d array, their is a possibility of having no saddle point. 
import java.util.Scanner;

public class Q73_Saddle_point {
 public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);
     int n = scn.nextInt();
     int[][] arr = new int[n][n];
     for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
             arr[i][j] = scn.nextInt();
         }
     }
     display(arr);
     sadlePoint(arr);
     scn.close();
 }   

 public static void sadlePoint(int[][] arr){
     for(int i = 0; i < arr.length; i++){
         int small_col = 0;
         for(int j = 1; j < arr[i].length; j++){
             if(arr[i][small_col] > arr[i][j]){
                 small_col = j;
             }   
         }
         boolean flag = true;
         for (int k = 0; k < arr.length; k++) {
             if(arr[k][small_col] > arr[i][small_col]){
                 flag = false;
                 break;
             }
         }
         if(flag == true){
             System.out.println(arr[i][small_col]);
             return;
         }
     }
     System.out.println("Invalid input");
     
 }

 public static void display(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }
}
}
