import java.util.Arrays;

public class Max_no_of_k_sum_pairs {

    // this is same as twoSum
    // we want to add two numbers from array if their sum equals to k then remove that two pairs and check
    // for other pairs
    // and return the total no of pairs
    // first of all sort the array now use two pointers, place one at first index and second at last index
    // if their sum is equal to k then increase count by 1 and increae i by 1 and decrese j by 1
    // if their sum is geater than k then decrese k else increae i and at end return the count
    public static int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] == k){
                count++;
                i++;
                j--;
            }
            else if(nums[i] + nums[j] < k){
                i++;
            }
            else{
                j--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }
}
 