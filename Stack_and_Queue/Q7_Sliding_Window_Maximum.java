import java.util.Scanner;
import java.util.Stack;

public class Q7_Sliding_Window_Maximum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        solve(arr, k);
    }
    public static void solve(int[] arr, int k) {
        int[] nextGreater = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        nextGreater[arr.length-1] = arr.length;
        for (int i = arr.length-2; i >= 0; i--) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nextGreater[i] = arr.length;
            }
            else{
                nextGreater[i] = st.peek();
            }
            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            if(j < i){
                j = i;
            }
            while(nextGreater[j] < i+k){
                j = nextGreater[j];
            }
            System.out.println(arr[j]);
        }
        

    }
}
