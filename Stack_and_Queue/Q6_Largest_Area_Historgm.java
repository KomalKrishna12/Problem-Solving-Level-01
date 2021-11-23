import java.util.Scanner;
import java.util.Stack;
//in this question we have to find max area 
//like arr -> 6, 2, 5, 4, 5, 1, 6
//like in this example element 4 area will be 4*3 because 4th right index till 1 and right till 2
//so width = right index - left index - 1
//area = width * arr[i]
//so we create two array rightindex and leftindex rightindex will show right side small index values
//leftindex will show left side small value
//if there is no right small value then store arr.length
//if there is no left small value then store -1
//then start loop from 0 to arr.length
//then calculate with and area and compare with each element area
//display max area
public class Q6_Largest_Area_Historgm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int[] rightSmallestIndex = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        rightSmallestIndex[arr.length-1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                rightSmallestIndex[i] = arr.length;
            }
            else{
                rightSmallestIndex[i] = st.peek();
            }
            st.push(i);
        }

        int[] leftSmallestIndex = new int[n];
        Stack<Integer> st2 = new Stack<>();
        st2.push(0);
        leftSmallestIndex[0] = -1;
        for (int i = 1; i < n; i++) {
            while(st2.size() > 0 && arr[i] < arr[st2.peek()]){
                st2.pop();
            }
            if(st2.size() == 0){
                leftSmallestIndex[i] = -1;
            }
            else{
                leftSmallestIndex[i] = st2.peek();
            }
            st2.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmallestIndex[i] - leftSmallestIndex[i] - 1;
            int area = width * arr[i];
            if(area > maxArea){
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
