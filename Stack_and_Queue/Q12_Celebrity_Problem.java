import java.util.Scanner;
import java.util.Stack;
//here we are given n which is no of ppl
//given a matrix of n*n which contain 0's and 1's
//we have to find a celebrrity
//celebrity means a person which don't know any one but everyone knows that persona
//arr[i][j] == 0 means i don't know j
//arr[i][j] == 1 means i knows j
//like n = 4
//matrix : 0000
//         1010
//         1100
//         1001
//here 0th index is celebrity because he don't know anyone but everyone knows him
//there can be one celebrity only beacause everone knows that celebrity that means there is no one
//who don't know the celeb
//but there is a chance that there is no celebrity like
//0001
//1010
//1100
//1001
//in this matrix no one is celebrity in first row he know last col person that's the reason
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
        while(st.size() >= 2){
            int i = st.pop();
            int j = st.pop();
            if(arr[i][j] == 1){
                //if i know j then i can't be a celebrity so push j
                st.push(j);
            }
            else if(arr[i][j] == 0){
                //if i don't know j then j can't be a celebrity so push i
                st.push(i);
            }
        }
        int potentialCeleb = st.pop();
        for (int i = 0; i < arr.length; i++) {
            //i != pot because diagonal means i == pot so a celebrity don't know him or her
            if(i != potentialCeleb)
            {
                if(arr[i][potentialCeleb] == 0 || arr[potentialCeleb][i] == 1){
                    //if i doesn't knows pot that means pot is not a celeb
                    //if pot knows i that means pot is not a celeb
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potentialCeleb);
    }

}
