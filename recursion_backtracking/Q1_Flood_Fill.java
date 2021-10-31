import java.util.Scanner;

public class Q1_Flood_Fill{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //n is no of rows in matrix
        //m is no of columns in matrix
        int n = scn.nextInt();
        int m = scn.nextInt();

        //it'll create an array of (n,m);
        int[][] arr = new int[n][m];

        //here we can receive elements of an array
        //we can go top > left > down > right in the array
        //if element is already visited we cannot go into that element
        //elements can be 0's & 1's if there is 1's then we cannot move in that direction
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        //this boolean array is created to check if the element is visited or not
        //when we create boolean array it'll contain false in every row and column by default
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
        scn.close();
    }
    public static void floodfill(int[][] arr, int row, int col, String ans, boolean[][] visited) {
        //when row < 0, col < 0 that means we're at negetive index so we return from that path
        //when row and column equal to length of array that means we're at out of bound so we return from 
        //that path
        //when arr[row][col] == 1 we return bcoz we can traverse through that row and col only
        //where element is 0
        //if the row or column is already visitedd than we cannot visit that particular row and column
        if(row < 0 || col < 0 || arr.length == row || arr[0].length == col || 
        arr[row][col] == 1 || visited[row][col] == true){
            return;
        }

        //if row == arr.length -1 and col == arr[0].length -1 that means we are at last row and last col
        //which is our destination so we print the ans and return from that path and try to search another
        //paths
        if(row == arr.length - 1 && col == arr[0].length - 1){
            System.out.println(ans);
            return;
        }

        //when we are going to visit any row or column firstly we mark it as true so that we cannot traverse 
        //to that path again and again
        visited[row][col] = true;

        //when we go top row - 1  and ans + "t"
        //when we go left col - 1 and ans + "l"
        //when we go down row + 1 and ans + "d"
        //when we go right col + 1 and ans + "r"
        floodfill(arr, row - 1, col, ans + "t", visited);
        floodfill(arr, row, col - 1, ans + "l", visited);
        floodfill(arr, row + 1, col, ans + "d", visited);
        floodfill(arr, row, col + 1, ans + "r", visited);   
        //after going in all direction we set false to the particular row and col so if there is another
        //path we can traverse that path also
        visited[row][col] = false;
    }
}