public class Q_ThreeSum {
    
    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,5,6} ;

        System.out.println( getThreeSum(arr, 13));

    }


    public static boolean getThreeSum(int[] arr , int sum) {
        
        for (int i = 0; i < arr.length - 1; i++) {
            
            if(twoSum(arr,i+1,sum - arr[i])){
                return true ;
            } 
        }


        return false ;
    }


    private static boolean twoSum(int[] arr, int i, int target) {

        int j = arr.length - 1 ;

        while (i < j) {
            
            if(arr[i] + arr[j] == target){
                return true ;
            }
            else{
                if(arr[i] + arr[j] > target){
                    i++ ;
                }
                else{
                    j--;
                }
            }
        }


        return false;
    }
}
