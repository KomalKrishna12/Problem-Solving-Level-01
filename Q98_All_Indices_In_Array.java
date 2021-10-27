import java.util.Scanner;

public class Q98_All_Indices_In_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        scn.close();
        int[] iarr = allIndices(arr,0,x,0);
        if(iarr.length == 0){
            System.out.println();
            return;
        }
        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
        
    }
    public static int[] allIndices(int[] arr, int index, int x, int fsf) {
        if(arr.length == index){
            return new int[fsf];
        }
        if(arr[index] == x){
            int[] iarr = allIndices(arr, index+1, x, fsf+1);
            iarr[fsf] = index;
            return iarr;
        }
        else{
            int[] iarr = allIndices(arr, index+1, x, fsf);
            return iarr;
        }
    }
}
