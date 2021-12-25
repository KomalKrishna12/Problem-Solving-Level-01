import java.util.Scanner;

public class Merge_sorted_array_leetcode {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        // int m = scn.nextInt();
        // int[] b = new int[m];
        // for (int i = 0; i < m; i++) {
        //     b[i] = scn.nextInt();
        // }
        scn.close();
        display(a);
        a = suppressZeroes(a);
        display(a);
        //int[] res = merge(a, b);
        //display(a);
        //display(b);
        //display(res);
    }

    public static int[] suppressZeroes(int[] arr){
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                size--;
            }
        }
        int[] res = new int[size];
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && j < res.length){
                res[j] = arr[i];
                j++;
            }
        }
        return res;
    }

    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        if(a.length == 0 && b.length == 0){
            return new int[0];
        }
        else if(a.length == 0 || b.length == 0){
            return a.length == 0 ? b : a;
        }
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
            }
            else{
                res[k] = b[j];
                j++;
            }
            k++;
        }
        while(i < a.length){
            res[k] = a[i];
            k++;
            i++;
        }
        while(j < b.length){
            res[k] = b[j];
            k++;
            j++;
        }
        return res;
    }
}
