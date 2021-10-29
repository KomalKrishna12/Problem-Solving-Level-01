package recursion_on_the_way_up;

import java.util.Scanner;

public class Q5_Print_Maze_Paths_With_Jumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //n is no of row and m is no of column in maze
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //here we are sending 1,1 in place of sr and sc, considering that we are at (1,1) and want to go at
        //(n,m) which is our destination.
        printMazePathsWithJumps(1, 1, n, m, "");
        scanner.close();
    }

    //sr is source row
    //sc is source column
    //dr is destination row
    //dr is destination column
    public static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String path) {

        //sr==dr and sc==dc that means we are at the destination now we can print the path and return 
        if(sr == dr && sc == dc){
            System.out.println(path);
            return;
        }

        for (int i = 1; i <= dc - sc; i++) {
            printMazePathsWithJumps(sr, sc + i, dr, dc, path + "h" + i);
        }

        for (int i = 1; i <= dr - sr; i++) {
            printMazePathsWithJumps(sr+i, sc, dr, dc, path + "v" + i);
        }

        for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
            printMazePathsWithJumps(sr + i, sc + i, dr, dc, path + "d" + i);
        }

    }
}
