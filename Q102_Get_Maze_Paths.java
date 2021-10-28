import java.util.ArrayList;
import java.util.Scanner;

public class Q102_Get_Maze_Paths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();// no of rows
        int m = scn.nextInt();// no of columns
        ArrayList<String> list = getMazePaths(1, 1, n, m);
        System.out.println(list);
        scn.close();
    }

    // sr is source row
    // sc is source column
    // dr is destination row
    // dc is destination column
    // suppose we take n and m as 3 and 3
    // if we take sr as 1 we take dr as 3, if we take sr as 0 we take dr as 2
    // if we take sc as 1 we take dc as 3, if we take sc as 0 we take dc as 2
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            //this is the base case if sr==dr && sc==dc that means it is already in destination so there is one
            //way to be at destination is stop there don't move.
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> hrPath = new ArrayList<>();
        ArrayList<String> vrPath = new ArrayList<>();
        if (sc < dc) {//if sc == 3 then it cannot go horizontal
            hrPath = getMazePaths(sr, sc + 1, dr, dc);// for horizontal path column will increase
        }
        if (sr < dr) {//if sr == 3 then it cannot go vertical
            vrPath = getMazePaths(sr + 1, sc, dr, dc);// for vertical path row will increase
        }
        ArrayList<String> paths = new ArrayList<>();
        //paths ArrayList contains path of traversing from (sr, sc) to (dr,dc)
        //if we add "h" in hrPath it will traversal from sc otherwise it will traverse from sc+1 which
        //we gave in getMazePaths() function
        for (String str : hrPath) {
            paths.add("h" + str);            
        }
        //if we add v in vrPath it will traversal from sr otherwise it will traverse from sr+1 which
        //we gave in getMazePaths() function
        for (String str : vrPath) {
            paths.add("v" + str);            
        }
        return paths;
    }
}
