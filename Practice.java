public class Practice{
    public static void main(String[] args) {
        int[] arr = {3,-4,2,-3,-1,7,-5};
        solution(arr);
    }
    public static void solution(int[] arr) {
        int curSum = arr[0];
        int bestSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if(curSum > arr[i]){
                curSum = arr[i];
            }
            if(curSum < bestSum){
                bestSum = curSum;
            }
        }
        System.out.println(bestSum);
    }
}