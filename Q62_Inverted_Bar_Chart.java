import java.util.Scanner;

public class Q62_Inverted_Bar_Chart {
 public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[] arr = new int[scn.nextInt()];
    for(int i = 0; i < arr.length; i++){
        arr[i] = scn.nextInt();
    }
   int max = arr[0];
   for(int i = 0; i < arr.length; i++){
       if(max < arr[i]){
           max = arr[i];
       }
   }
   for(int i = 1 ; i <= max; i++){
       for(int j = 0; j < arr.length; j++){
           if(arr[j] >= i){
               System.out.print("*\t");
           }
           else{
               System.out.print("\t");
           }
       }
       System.out.println();
   }
   scn.close();
 }   
}
