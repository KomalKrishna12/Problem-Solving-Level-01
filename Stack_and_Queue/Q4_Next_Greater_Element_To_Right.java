import java.util.Scanner;
import java.util.Stack;

public class Q4_Next_Greater_Element_To_Right {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int[] ans = solve(arr);
        display(ans);
    }
    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        ans[arr.length-1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            while(st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
