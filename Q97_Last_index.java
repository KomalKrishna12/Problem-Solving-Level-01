import java.util.Scanner;

public class Q97_Last_index {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        System.out.println(lastIndex(arr,0,x));
        scn.close();
    }
    public static int lastIndex(int[] arr, int index, int x) {
        if(arr.length == index){
            return -1;
        }
        int lastIndexInSmallestArr = lastIndex(arr, index + 1, x);
        if(lastIndexInSmallestArr == -1){
            if(arr[index] == x){
                return index;
            }
            else{
                return -1;
            }
        }
        else{
            return lastIndexInSmallestArr;
        }
    }
}
