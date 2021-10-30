public class TwoSum{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        twoSum(arr, arr.length);
    }
    public static void twoSum(int[] arr, int j){
        for (int i = 0; i < j; i++) {
            System.out.println(arr[i]);
        }
    }
}