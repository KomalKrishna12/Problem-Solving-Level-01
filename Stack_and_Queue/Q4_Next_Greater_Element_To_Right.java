import java.util.Scanner;
import java.util.Stack;
//In this ques we have to find next greater element to right
//suppose we have n = 5
//create arr of size 5
//arr -> {5, 3, 8, -2, 7}
//Next greater element of 5 to right 8
//Next greater element of 3 to right 8
//Next greater element of 8 to right -1
//Next greater element of -2 to right 7
//Next greater element of 7 to right -1
//at end it'll always be -1 beacuse no right element at end of array
//if there is no greater element available at right for particular element then that will be -1
//to solve this we can use concept of stack
//create an array ans whose size is similar with array size this ans array will use to store next greater
//element at right
//start from end of arr
//push end element in stack and add -1 to ans array at end index
//start for loop from i = arr.length - 1 to 0
//check stack.size()>0 && arr[i] >= stack.peek() that means check wheather the stack is not empty
//stack peek is less than arr[i] then stack.pop() till we get larger element at peek()
//do this is while loop
//after end of this loop push the element into stack
//if stack is empty then store -1 in ans array for the particular index that means there is no greater
//element present at right end
//else store peek() of array that is the next greater right element of array
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
