import java.util.Scanner;

public class Q48_Span_Of_An_Array {
 public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);
     int[] arr = new int[scn.nextInt()];
     for (int i = 0; i < arr.length; i++) {
         arr[i] = scn.nextInt();
     }
    //  System.out.println(findMax(arr));
    //  System.out.println(findMin(arr));
     scn.close();

     int max = arr[0] ;
     int min = arr[0] ;

     for (int i : arr) {
         max = i > max ? i : max ;
        
         if(min > i) min = i ;
     }

     System.out.println(max);
     System.out.println(min);

 }
 public static int findMax(int[] arr) {
     int max = arr[0];
     for (int i = 1; i < arr.length; i++) {
         if(max < arr[i]){
             max = arr[i];
         }
     }
     return max;
 }
 public static int findMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if(min > arr[i]){
            min = arr[i];
        }
    }
    return min;
}
}
