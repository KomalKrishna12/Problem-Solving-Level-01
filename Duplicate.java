import java.util.Arrays;

public class Duplicate {
    public static void main(String[] args) {

        int[] arr = {0,2,2,1,4,7,9};
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                System.out.println("duplicate element : " + arr[i]);
                break;
            }
        }
        
    }
}
