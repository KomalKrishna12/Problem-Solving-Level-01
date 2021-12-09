import java.util.HashMap;
import java.util.Scanner;
// N = 7
// a[] = {2,6,1,9,4,5,3}
// Output:
// 6
public class Q5_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();

        HashMap<Integer, Boolean> hm = new HashMap<>();
        // firstly set all as true in value
        for (int val : arr) {
            hm.put(val, true);
        }
        // now check that there decreament by 1 number is their in hm or not
        // if previous no is there that means this curr val is not the starting point so set false
        // else it is the starting point
        for (int val : arr) {
            if(hm.containsKey(val - 1)){
                hm.put(val, false);
            }
        }

        int maxLen = 0;
        int maxStartPoint = 0;
        // if val is true then craete temp len as 1 and temp start point as val
        // create a while loop if hm containes val + temp length then increase temp len by 1
        // and check cond again
        // after loop compare max len with temp len
        // if tmp len is greater then assign max len as temp len and max start point as temp start point
        int count = 0;
        for (int val : arr) {
            if(hm.get(val) == true){
                int tempLen = 1;
                int tempStartPoint = val;
                int tcount = 1;
                while(hm.containsKey(val + tempLen)){
                    tempLen++;
                    tcount++;
                }
                if(tempLen > maxLen){
                    maxLen = tempLen;
                    maxStartPoint = tempStartPoint;
                    count = tcount;
                }
            }
        }

        // now create a for loop start from 0 and till i is less that max length
        // and display max start point + i
        
        for (int i = 0; i < maxLen; i++) {
            System.out.println(maxStartPoint + i);
        }
        System.out.println("count : " + count);
    }
}
