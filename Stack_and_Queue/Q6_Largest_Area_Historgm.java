import java.util.Scanner;
import java.util.Stack;

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
        st.push(0);
        leftSmallestIndex[0] = -1;
        for (int i = 1; i < n; i++) {
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                leftSmallestIndex[i] = -1;
            }
            else{
                leftSmallestIndex[i] = st.peek();
            }
            st.push(i);
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
}
