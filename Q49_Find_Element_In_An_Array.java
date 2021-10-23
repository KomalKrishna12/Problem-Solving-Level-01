import java.util.Scanner;

public class Q49_Find_Element_In_An_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        scn.close();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == data){
                index = i;
                break;
            }
        }
        System.out.println(index);

    }
}
