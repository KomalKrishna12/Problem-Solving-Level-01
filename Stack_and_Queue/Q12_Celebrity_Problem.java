import java.util.Scanner;
import java.util.Stack;

public class Q12_Celebrity_Problem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        findCelebrity(arr);
    }

    private static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        int potentialCeleb = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if(i != potentialCeleb)
            {
                if(arr[i][potentialCeleb] == 0 || arr[potentialCeleb][i] == 1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potentialCeleb);
    }

}
