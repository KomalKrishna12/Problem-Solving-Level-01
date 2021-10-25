//array of n*m given and shell no is also given
//r is given means in the particular shell we have to rotate the element r times.
//firstly we take one d array from shell then we rotate that one d array and again put that array
//in shell.
import java.util.Scanner;

public class Q70_Ring_Rotate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int s = scanner.nextInt();
        int r = scanner.nextInt();
        rotate(arr,s,r);
        display(arr);
        scanner.close();
    }

    public static void rotate(int[][] arr, int s, int r) {
        int[] oneD = filloneDArray(arr,s);
        rotateOneDArray(oneD,r);
        fillArrayFromOneD(arr, s, oneD);
    }

    public static void rotateOneDArray(int[] oneD, int r){
        r = r % oneD.length;
        if(r < 0){
            r += oneD.length;
        }
        reverse(oneD,0,oneD.length-r-1);
        reverse(oneD,oneD.length-r,oneD.length-1);
        reverse(oneD,0,oneD.length-1);
        
    }

    public static void reverse(int[] arr, int i, int j) {
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void fillArrayFromOneD(int[][] arr, int s, int[] oneD){
        int minr = s-1;
        int minc = s-1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;
        int index = 0;

        //lw
        for(int i = minr, j = minc; i <= maxr; i++){
            arr[i][j] = oneD[index];
            index++;
        }

        //bw
        for(int i = maxr, j = minc + 1; j <= maxc; j++){
            arr[i][j] = oneD[index];
            index++;
        }

        //rw
        for(int i = maxr - 1, j = maxc; i >= minr; i--){
            arr[i][j] = oneD[index];
            index++;
        }

        //tw
        for(int i = minr, j = maxc - 1; j >= minc + 1; j--){
            arr[i][j] = oneD[index];
            index++;
        }
    }

    public static int[] filloneDArray(int[][] arr, int s){
        
        int minr = s-1;
        int minc = s-1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;
        int size = 2 * (maxr - minr + maxc - minc);
        int[] oneD = new int[size];
        int index = 0;

        //lw
        for(int i = minr, j = minc; i <= maxr; i++){
            oneD[index] = arr[i][j];
            index++;
        }

        //bw
        for(int i = maxr, j = minc + 1; j <= maxc; j++){
            oneD[index] = arr[i][j];
            index++;
        }

        //rw
        for(int i = maxr - 1, j = maxc; i >= minr; i--){
            oneD[index] = arr[i][j];
            index++;
        }

        //tw
        for(int i = minr, j = maxc - 1; j >= minc + 1; j--){
            oneD[index] = arr[i][j];
            index++;
        }

        return oneD;
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
