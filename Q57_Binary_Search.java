import java.util.Scanner;

public class Q57_Binary_Search {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90,100};
        Scanner scn = new Scanner(System.in);
        int data = scn.nextInt();
        scn.close();
        int i = 0;
        int j = arr.length - 1;
        while(i <= j){
            int mid = i + j / 2;
            if(data < arr[mid]){
                j = mid - 1;
            }
            else if(data > arr[mid]){
                i = mid + 1;
            }
            else{
                System.out.println(mid);
                return;
            }
        }
        System.out.println(-1);
     }
}
