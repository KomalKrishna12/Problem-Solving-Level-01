import java.util.*;

public class TwoSum {
    static class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        for(int i = 0; i < n - 1; i++){
            int val1 = arr[i];
            int val2 = arr[i + 1];
            if(val1 + val2 == k) count++;
        }
        return count;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(target - val) == true && map.get(target - val) != i) {
                res[0] = i;
                res[1] = map.get(target - val);
                
                break;
            }
        }


        return res;
    }

    static  class comp implements Comparator<pair>{

        @Override
        public int compare(pair o1, pair o2) {
            return (int) (o1.first - o2.first) ;
        }

    }

    public static pair[] allPairs( long A[], long B[], long N, long M, long X) {
        HashSet<Long> set = new HashSet<>();
        for(int i = 0; i < M; i++){
            set.add(B[i]);
        }
        int min = (int) Math.min(N, M);
        pair[] arr = new pair[min];
        int idx = 0;
        for(int i = 0; i < N; i++){
            long val = A[i];
            if(set.contains(X - val)){
                arr[idx] = new pair(val, X - val);
                idx++;
                //System.out.println(val + " " + (X - val));
            }
        }
        pair[] res = new pair[idx];
        for(int i = 0; i < idx; i++){
            res[i] = arr[i];
        }
        Arrays.sort(res, new comp());
        return res;
    }

    public static void display(int[] nums) {
        for (int val : nums) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] nums = { 3, 3 };
        // int target = 6;
        // display(nums);
        // int[] res = twoSum(nums, target);
        // display(res);

        // long A[] = {1, 2, 4, 5, 7};
        // long B[] = {5, 6, 3, 4, 8};
        // allPairs(A, B, A.length, B.length, 9); 
        int[] arr = {1, 1, 1, 1};
        System.out.println(getPairsCount(arr, arr.length, 2));
    }
}
