package recursion_on_the_way_up;

import java.util.Scanner;

public class Q4_Print_Maze_Paths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //n is no of row and m is no of column in maze
        int n = scn.nextInt();
        int m = scn.nextInt();

        //here we are sending 1,1 in place of sr and sc, considering that we are at (1,1) and want to go at
        //(n,m) which is our destination.
        printMazePaths(1, 1, n, m, "");
        scn.close();
    }
    //sr is source row
    //sc is source column
    //dr is destination row
    //dr is destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String path) {
        //sr==dr and sc==dc that means we are at the destination now we can print the path and return 
        if(sr == dr && sc == dc){
            System.out.println(path);
            return;
        }

        //when sc < dc then only we can take horizontal path
        //for example we are at (1,3) and our destination is (3,3) now we cannot go horizontal any more
        //becoz this is the boundary same will apply with sr and dr. 
        if(sc < dc){
            printMazePaths(sr, sc+1, dr, dc, path+"h");
        }
        if(sr<dr){
            printMazePaths(sr+1, sc, dr, dc, path+"v");
        }
    }
}
