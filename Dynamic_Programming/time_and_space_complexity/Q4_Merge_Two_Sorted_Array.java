import java.util.Scanner;

public class Q4_Merge_Two_Sorted_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //size of first array
        int n = scn.nextInt();
        int[] a = new int[n];
        //elements of first array
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        //size of third array
        int m = scn.nextInt();
        int[] b = new int[m];
        //elements of second array
        for (int i = 0; i < b.length; i++) {
            b[i] = scn.nextInt();
        }
        //finl array which we get from merge function
        int[] res = merge(a, b);
        //display elements of final array
        printArray(res);
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if(i < a.length){
                a[i] = res[i];
            }
            else if(j < b.length){
                b[j] = res[i];
                j++;
            }
        }
        printArray(a);
        printArray(b);
        scn.close();
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //res array size will be addition of size of first array and second array
    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        //let us suppose we're creating index i for array a, j for array b and k for array res
        int i = 0;
        int j = 0;
        int k = 0;
        //when both arrays are having elements we compare there elements, the smallest element will
        //store at kth index of res array
        while(i < a.length && j < b.length){
            //when a[i] s smaller then we add a[i] in res array and increase value of i an k
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
                k++;
            }
            else{
                res[k] = b[j];
                j++;
                k++;
            }
        }
        //suppose second array size is smaller than first array then we again run the loop for adding
        //first array elements in res array
        while(i < a.length){
            res[k] = a[i];
            i++;
            k++;
        }
        //same as before if second array is bigger than simply place values of second array in res array
        while(j < b.length){
            res[k] = b[j];
            j++;
            k++;
        }
        return res;
    }
}
