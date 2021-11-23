import java.util.Scanner;
import java.util.Stack;
//this is same question like before we solve next greater element to right
//here we have to find next greater elment to left if there is no greater element then store i + 1
//for first element we store 1 becoz there is no greater element at left so we store i + 1 and for first 
//element i is 0 and add i in stack bcoz we want to perform operations on index
//create loop for 1 to n
//if stack is not empty and arr[st.peek()] < arr[i] then pop the st.peek () value
//at end check wheather the stack is empty or not
//if empty that means no greater element at right so store i + 1
//else store span (diff between i and st.peek()) for that index
//at end push ith index
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