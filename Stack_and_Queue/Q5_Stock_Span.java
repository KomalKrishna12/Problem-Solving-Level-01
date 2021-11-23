import java.util.Scanner;
import java.util.Stack;

public class Q5_Stock_Span{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int[] ans = solve(arr);
        display(ans);
        scn.close();
    }
    public static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            while(st.size() > 0 && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = i+1;
            }
            else{
                ans[i] = i - st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}